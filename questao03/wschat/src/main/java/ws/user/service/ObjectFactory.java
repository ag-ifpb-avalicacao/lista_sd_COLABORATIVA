
package ws.user.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.user.service package. 
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

    private final static QName _User_QNAME = new QName("http://service.user.ws/", "user");
    private final static QName _List_QNAME = new QName("http://service.user.ws/", "list");
    private final static QName _ListResponse_QNAME = new QName("http://service.user.ws/", "listResponse");
    private final static QName _Remove_QNAME = new QName("http://service.user.ws/", "remove");
    private final static QName _RemoveResponse_QNAME = new QName("http://service.user.ws/", "removeResponse");
    private final static QName _StoreResponse_QNAME = new QName("http://service.user.ws/", "storeResponse");
    private final static QName _Store_QNAME = new QName("http://service.user.ws/", "store");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.user.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveResponse }
     * 
     */
    public RemoveResponse createRemoveResponse() {
        return new RemoveResponse();
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
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new Remove();
    }

    /**
     * Create an instance of {@link ListResponse }
     * 
     */
    public ListResponse createListResponse() {
        return new ListResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.user.ws/", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.user.ws/", name = "list")
    public JAXBElement<List> createList(List value) {
        return new JAXBElement<List>(_List_QNAME, List.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.user.ws/", name = "listResponse")
    public JAXBElement<ListResponse> createListResponse(ListResponse value) {
        return new JAXBElement<ListResponse>(_ListResponse_QNAME, ListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remove }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.user.ws/", name = "remove")
    public JAXBElement<Remove> createRemove(Remove value) {
        return new JAXBElement<Remove>(_Remove_QNAME, Remove.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.user.ws/", name = "removeResponse")
    public JAXBElement<RemoveResponse> createRemoveResponse(RemoveResponse value) {
        return new JAXBElement<RemoveResponse>(_RemoveResponse_QNAME, RemoveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.user.ws/", name = "storeResponse")
    public JAXBElement<StoreResponse> createStoreResponse(StoreResponse value) {
        return new JAXBElement<StoreResponse>(_StoreResponse_QNAME, StoreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Store }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.user.ws/", name = "store")
    public JAXBElement<Store> createStore(Store value) {
        return new JAXBElement<Store>(_Store_QNAME, Store.class, null, value);
    }

}
