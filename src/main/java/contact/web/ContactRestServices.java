package contact.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import contact.dao.ContactRepository;
import contact.entities.Contact;

@RestController
@CrossOrigin( "*" )
public class ContactRestServices {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping( value = "/contacts", method = RequestMethod.GET )
    public Page<Contact> contacts(
            @RequestParam( name = "page", defaultValue = "0" ) int page,
            @RequestParam( name = "size", defaultValue = "6" ) int size ) {
        return contactRepository.findAll( new PageRequest( page, size ) );
    }

    @RequestMapping( value = "/chercherContact", method = RequestMethod.GET )
    public Page<Contact> contactParMC( @RequestParam( name = "mc", defaultValue = "" ) String mc,
            @RequestParam( name = "page", defaultValue = "0" ) int p,
            @RequestParam( name = "size", defaultValue = "6" ) int s ) {
        return contactRepository.listeContactParMC( "%" + mc + "%", new PageRequest( p, s ) );
    }

    @RequestMapping( value = "/contact/{id}", method = RequestMethod.GET )
    public Contact contact( @PathVariable Long id ) {
        Optional<Contact> c = contactRepository.findById( id );
        return c.get();
    }

    @RequestMapping( value = "/contacts/{id}", method = RequestMethod.DELETE )
    public boolean delete( @PathVariable Long id ) {
        contactRepository.deleteById( id );
        return true;
    }

    @RequestMapping( value = "/contacts", method = RequestMethod.POST )
    public Contact saveContact( @RequestBody Contact c ) {
        return contactRepository.save( c );

    }

    @RequestMapping( value = "/contacts/{id}", method = RequestMethod.PUT )
    public Contact updateContact( @PathVariable Long id, @RequestBody Contact c ) {
        //Contact contact = contactRepository.findById( id ).get();
    	c.setId(id);
        return contactRepository.save( c ); 

    }

}
