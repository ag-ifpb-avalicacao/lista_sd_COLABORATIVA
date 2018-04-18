package br.com.ifpb.sd.shared;

import java.io.Serializable;

/**
 *
 * @author rodrigobento
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nickname;
    private String pass;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" + "nickname=" + nickname + ", pass=" + pass + '}';
    }
    
}
