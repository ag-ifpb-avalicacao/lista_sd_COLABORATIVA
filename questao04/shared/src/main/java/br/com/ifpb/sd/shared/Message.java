package br.com.ifpb.sd.shared;

import java.io.Serializable;

/**
 *
 * @author rodrigobento
 */
public class Message implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
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

    @Override
    public String toString() {
        return "Message{" + "userOwner=" + userOwner + ", content=" + content + '}';
    }
    
}
