/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.shared;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan
 */
@XmlRootElement
public class Message {

    private String userOwner;
    private String content;

    public String getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(String userOwner) {
        this.userOwner = userOwner;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
