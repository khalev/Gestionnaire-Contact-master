package contact;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import contact.dao.ContactRepository;
import contact.entities.Contact;

@SpringBootApplication
public class TpContactApplication implements CommandLineRunner {

    @Autowired
    private ContactRepository contactRepository;

    public static void main( String[] args ) {
        SpringApplication.run( TpContactApplication.class, args );
    }

    @Override
    public void run( String... args ) throws Exception {
        DateFormat df = new SimpleDateFormat( "dd/MM/yyyy" );
        
		/*
		 * contactRepository.save( new Contact( "Kane", "Cheikh Tidiane", df.parse(
		 * "25/08/1997" ), "+221777587450", "cheikh.jpg" ) ); contactRepository.save(
		 * new Contact( "Barry", "Aissatou", df.parse( "25/01/1998" ), "+221777587450",
		 * "bary.jpg" ) ); contactRepository.save( new Contact( "Camara",
		 * "Abdou Rakhman", df.parse( "25/08/1997" ), "+221777587450", "abdou.jpg" ) );
		 * contactRepository.save( new Contact( "Diaw", "Ababacar", df.parse(
		 * "25/08/1994" ), "+2217725400", "babs.jpg" ) ); contactRepository.save( new
		 * Contact( "Ngom", "Mouhamed Lamine", df.parse( "25/08/1999" ),
		 * "+221778785620", "ngom.jpg" ) );
		 * 
		 * 
		 * contactRepository .save( new Contact( "Diallo", "El Hadji", df.parse(
		 * "25/08/1992" ), "+22178541221", "diallo.jpg" ) ); contactRepository .save(
		 * new Contact( "Sarr", "Daouda", df.parse( "25/08/1992" ), "+22178812021",
		 * "sarr.jpg" ) ); contactRepository .save( new Contact( "Sow", "Ramata",
		 * df.parse( "25/08/1992" ), "+221785412021", "diallo.jpg" ) );
		 * 
		 * contactRepository .save( new Contact( "Guisse", "Mamadou", df.parse(
		 * "25/08/1992" ), "+22178541221", "guisse.jpg" ) ); contactRepository .save(
		 * new Contact( "Lo", "Pathe", df.parse( "25/08/1992" ), "+22178812021",
		 * "lo.jpg" ) ); contactRepository .save( new Contact( "Kasse", "Mouhamed",
		 * df.parse( "25/08/1992" ), "+221785412021", "kasse.jpg" ) );
		 * 
		 * contactRepository.findAll().forEach( c -> { System.out.println( c.getNom() );
		 * } );
		 */

    }
}