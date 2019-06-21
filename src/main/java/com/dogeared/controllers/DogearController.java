package com.dogeared.controllers;

import com.dogeared.models.Dogear;
import com.dogeared.models.Media;
import com.dogeared.models.MediaType;
import com.dogeared.models.User;
import com.dogeared.models.data.DogearDao;
import com.dogeared.models.data.MediaDao;
import com.dogeared.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DogearController extends AbstractController {

  @Autowired UserDao userDao;
  @Autowired MediaDao mediaDao;
  @Autowired DogearDao dogearDao;

  @RequestMapping(value = "/dogear")
  public String dogearMain(Model model, HttpSession session) {
    System.out.println("made it to the dogear controller");
    User user = getUserFromSession(session);
    if (user != null) {

      //add medias for dropdown
      List<Media> medias = mediaDao.findByUserUid(user.getUid());
      if (medias != null) {
        System.out.println("media list size " + medias.size());
        model.addAttribute("medias", medias);
      }

      //display dogears
      List<Dogear> dogears = dogearDao.findByUserUid(user.getUid());
      if (medias != null) {
        System.out.println("dogears list size " + dogears.size());
        model.addAttribute("dogears", dogears);
      }
    }
    return "dogear";
  }

  @RequestMapping(value = "/dogear/add/media_type", method = RequestMethod.POST)
  public String addMediaType(
      @RequestParam String title, @RequestParam String mediaType, HttpSession session) throws Exception {
    System.out.println("made it to the dogear addMediaType");

    User user = getUserFromSession(session);

    if (user != null) {
      Media media = new Media(title, MediaType.valueOf(mediaType), user);
      mediaDao.save(media);
    } else {
      throw new Exception("user was null");
    }

    return "redirect:/dogear";
  }

  @RequestMapping(value = "/dogear/add/dogear", method = RequestMethod.POST)
  public String addEarMark(
      @RequestParam String earmark, @RequestParam String note, @RequestParam String tempMediaId, HttpSession session) throws Exception {
    System.out.println("made it to the dogear addEarMark");
    int mediaUid = Integer.valueOf(tempMediaId);
    User user = getUserFromSession(session);
    Media thisMedia = findByMediaUid(mediaUid, user);

    if(user != null) {
      Dogear dogear = new Dogear(earmark, note, user, thisMedia);
      dogearDao.save(dogear);
    } else {
      throw new Exception("user was null");
    }

    return "redirect:/dogear";
  }


  public Media findByMediaUid(int id, User user) {
    List<Media> medias = mediaDao.findByUserUid(user.getUid());
    Media media = null;
    for (int i = 0; i <medias.size(); i++) {
      Media temp = medias.get(i);
      if (temp.getUid() == id) {
        media = temp;
      }
    }
    return media;
  }

}
