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
public class User {

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
}
