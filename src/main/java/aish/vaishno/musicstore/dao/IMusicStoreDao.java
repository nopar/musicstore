/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aish.vaishno.musicstore.dao;

import aish.vaishno.musicstore.pojo.MusicDetail;
import java.util.List;

/**
 *
 * @author Aishu
 */
public interface IMusicStoreDao {
    
    public String addSong(MusicDetail musicDetail);
    public List<MusicDetail> getSongList();
    
    /**/
        public MusicDetail getSong(int musicID);
	public void deleteSong(int musicID);
        public void updateSong(MusicDetail musicDetail);
}
