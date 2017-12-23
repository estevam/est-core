package com.est.rest.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Estevam
 */
public class PowerBox {

    private String iAccessToken;
    private String iCmdRoot = "http://127.0.0.1";


    public PowerBox(String aRoot, String aToken) {
        iAccessToken = aToken.toString();
        iCmdRoot = aRoot.toString();
    }

 
 
    public void tv_queue_add(String aMediaUrl) {
        String addQueue = iCmdRoot + "/service/tags?access_token="
                + iAccessToken;
        HttpActionSimples.post(addQueue, "uri=" + aMediaUrl);
    }

    public void tv_playlist_add(String aMediaUrl) {
        String addPlayList = iCmdRoot + "/service/playlist/default?access_token="
                + iAccessToken;
        HttpActionSimples.post(addPlayList, "uri=" + aMediaUrl);
    }

    public void tv_queue_delete(String aMediaUid) {
        String deleteQueue = iCmdRoot + "/service/tags/" + aMediaUid
                + "?access_token=" + iAccessToken;
        HttpActionSimples.delete(deleteQueue);
    }

    public void tv_pvr_schedule_delete(String aUid) {
        String deletePrvShedule = iCmdRoot + "/service/me/pvr/" + aUid
                + "?access_token=" + iAccessToken;
        HttpActionSimples.delete(deletePrvShedule);
    }

    public void tv_playlist_delete(String aMediaUid) {
        String deleteFileList = iCmdRoot + "/service/playlist/default/"
                + aMediaUid + "/?access_token="
                + iAccessToken;
        HttpActionSimples.delete(deleteFileList);
    }

    public void tv_playlist_delete_all() {
        String deleteAllList = iCmdRoot + "/service/playlist/default?access_token="
                + iAccessToken;
        HttpActionSimples.delete(deleteAllList);
    }

    public void tv_delete_pvr(String aUid) {
        String delete_prv = iCmdRoot + "/service/mediabrowse/pvr/"
                + aUid + "?access_token=" + iAccessToken;
        HttpActionSimples.delete(delete_prv);
    }

    public void sendMsgOnChat(String aMsg, int aChatCod) {
        try {
            aMsg = URLEncoder.encode(aMsg, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PowerBox.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        String urlMsg = "http://richman.disternets.com:8082/webapi/discussionpost/Mediaurl?&maxchats=2&startIndex=0&access_token="
                + iAccessToken
                + "&comment=" + aMsg
                + "&privacy=" + aChatCod;
        HttpActionSimples.get(urlMsg);

    }

    public void tv_user_delete(String aUserId) {
        String delete = iCmdRoot + "/service/auth/user/" + aUserId;
        HttpActionSimples.delete(delete);
    }

    public void tv_powercache_post(String aUrl, String aMediaurl, String aTitle, String aDescription, int type) {
        String powercache_post = iCmdRoot + "/service/powercache?access_token="+ iAccessToken;
        HttpActionSimples.post(powercache_post, "&url=" + aUrl + "&mediaurl=" + aMediaurl + "&title=" + aTitle + "&description=" + aDescription + "&type" + type);

     }


}
