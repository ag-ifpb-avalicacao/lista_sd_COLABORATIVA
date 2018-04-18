package br.com.ifpb.sd.message.repository;

import br.com.ifpb.sd.shared.Message;
import java.util.List;

/**
 *
 * @author rodrigobento
 */
public interface MessageDao {
    
    void insert(Message message);
    List<Message> listAll();
    
}
