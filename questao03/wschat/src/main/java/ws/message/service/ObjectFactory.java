
package ws.message.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.message.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Store_QNAME = new QName("http://service.message.ws/", "store");
    private final static QName _StoreResponse_QNAME = new QName("http://service.message.ws/", "storeResponse");
    private final static QName _ListResponse_QNAME = new QName("http://service.message.ws/", "listResponse");
    private final static QName _List_QNAME = new QName("http://service.message.ws/", "list");
    private final static QName _Message_QNAME = new QName("http://service.message.ws/", "message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.message.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StoreResponse }
     * 
     */
    public StoreResponse createStoreResponse() {
        return new StoreResponse();
    }

    /**
     * Create an instance of {@link Store }
     * 
     */
    public Store createStore() {
        return new Store();
    }

    /**
     * Create an instance of {@link List }
     * 
     */
    public List createList() {
        return new List();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link ListResponse }
     * 
     */
    public ListResponse createListResponse() {
        return new ListResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Store }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.message.ws/", name = "store")
    public JAXBElement<Store> createStore(Store value) {
        return new JAXBElement<Store>(_Store_QNAME, Store.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.message.ws/", name = "storeResponse")
    public JAXBElement<StoreResponse> createStoreResponse(StoreResponse value) {
        return new JAXBElement<StoreResponse>(_StoreResponse_QNAME, StoreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.message.ws/", name = "listResponse")
    public JAXBElement<ListResponse> createListResponse(ListResponse value) {
        return new JAXBElement<ListResponse>(_ListResponse_QNAME, ListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.message.ws/", name = "list")
    public JAXBElement<List> createList(List value) {
        return new JAXBElement<List>(_List_QNAME, List.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Message }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.message.ws/", name = "message")
    public JAXBElement<Message> createMessage(Message value) {
        return new JAXBElement<Message>(_Message_QNAME, Message.class, null, value);
    }

}
