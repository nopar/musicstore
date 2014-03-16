package aish.vaishno.musicstore.controller;

import aish.vaishno.musicstore.dao.IMusicStoreDao;
import aish.vaishno.musicstore.pojo.MusicDetails;
import aish.vaishno.musicstore.service.IMusicStoreService;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

        @Autowired
        private IMusicStoreService musicStoreService;
    
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
            
		return new ModelAndView("home","musicDetForm",new MusicDetails());
	}
        
        @RequestMapping(value="AddSong",method = RequestMethod.POST)
        @ResponseBody
        public String addSong(@ModelAttribute("musicDetForm") MusicDetails musicDetails){
           return musicStoreService.addSong(musicDetails);
        }
        
        @RequestMapping(value = "SongList/",method = RequestMethod.GET)
        @ResponseBody
        public List<MusicDetails> getSongList(){
            return musicStoreService.getSongList();
        }
        
        @RequestMapping(value="list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("list");
		
		List<MusicDetails> polozky = musicStoreService.getSongList();
		modelAndView.addObject("polozky", polozky);
		
		return modelAndView;
	}
}
