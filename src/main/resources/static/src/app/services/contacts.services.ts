import {Injectable, OnInit} from '@angular/core';
import {Subject, Subscription} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {ContactModel} from '../models/contact.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Injectable()
export class ContactsServices implements OnInit{
contact:ContactModel;
contactForm:FormGroup;
constructor(private http:HttpClient,
            private contactBuilder:FormBuilder){

}

  ngOnInit(){

 this.initForm();
  }
  initForm(){
    this.contactForm = this.contactBuilder.group({
      nom:['',Validators.required],
      prenom:['',Validators.required],
      dateNaissance:['',Validators.required],
      telephone:['+2217xxxxxxxx',Validators.required],
      pathImage:'xxx.jpg'
    });
  }

  getContacts(motCle:string,page:number,size:number){
  const url = "http://localhost:8080/chercherContact?mc="+motCle+"&page="+page+"&size="+size;
   return  this.http.get<any>(url);
  }

  addContact(contact:ContactModel){
     const url = "http://localhost:8080/contacts";
     this.http.post(url,contact)
       .subscribe(
         (resp:any)=>{
           console.log('Enregistrement reussit');
           this.contact = resp;
         },
         (error)=>{
           console.log('Echec de l\'enregistrement ');
         }
       );
  }



}
