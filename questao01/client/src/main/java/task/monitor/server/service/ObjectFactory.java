
package task.monitor.server.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the task.monitor.server.service package. 
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

    private final static QName _Registry_QNAME = new QName("http://service.server.monitor.task/", "registry");
    private final static QName _RegistryResponse_QNAME = new QName("http://service.server.monitor.task/", "registryResponse");
    private final static QName _List_QNAME = new QName("http://service.server.monitor.task/", "list");
    private final static QName _ListResponse_QNAME = new QName("http://service.server.monitor.task/", "listResponse");
    private final static QName _TaskEvent_QNAME = new QName("http://service.server.monitor.task/", "taskEvent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: task.monitor.server.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Registry }
     * 
     */
    public Registry createRegistry() {
        return new Registry();
    }

    /**
     * Create an instance of {@link RegistryResponse }
     * 
     */
    public RegistryResponse createRegistryResponse() {
        return new RegistryResponse();
    }

    /**
     * Create an instance of {@link List }
     * 
     */
    public List createList() {
        return new List();
    }

    /**
     * Create an instance of {@link ListResponse }
     * 
     */
    public ListResponse createListResponse() {
        return new ListResponse();
    }

    /**
     * Create an instance of {@link TaskEvent }
     * 
     */
    public TaskEvent createTaskEvent() {
        return new TaskEvent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Registry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.monitor.task/", name = "registry")
    public JAXBElement<Registry> createRegistry(Registry value) {
        return new JAXBElement<Registry>(_Registry_QNAME, Registry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.monitor.task/", name = "registryResponse")
    public JAXBElement<RegistryResponse> createRegistryResponse(RegistryResponse value) {
        return new JAXBElement<RegistryResponse>(_RegistryResponse_QNAME, RegistryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.monitor.task/", name = "list")
    public JAXBElement<List> createList(List value) {
        return new JAXBElement<List>(_List_QNAME, List.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.monitor.task/", name = "listResponse")
    public JAXBElement<ListResponse> createListResponse(ListResponse value) {
        return new JAXBElement<ListResponse>(_ListResponse_QNAME, ListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.monitor.task/", name = "taskEvent")
    public JAXBElement<TaskEvent> createTaskEvent(TaskEvent value) {
        return new JAXBElement<TaskEvent>(_TaskEvent_QNAME, TaskEvent.class, null, value);
    }

}
