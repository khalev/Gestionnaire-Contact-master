import { Component, OnInit } from '@angular/core';
import {ContactsServices} from '../services/contacts.services';
import {FormGroup} from '@angular/forms';
import {ContactModel} from '../models/contact.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-new-contact',
  templateUrl: './new-contact.component.html',
  styleUrls: ['./new-contact.component.css']
})
export class NewContactComponent implements OnInit {
  contactForm:FormGroup;
  public contact:ContactModel;
  mode:number=1;
  constructor(private contactService:ContactsServices,
              private route:Router) { }

  ngOnInit() {
    this.contactService.initForm();
    this.contactForm = this.contactService.contactForm;
  }


  addContact(){
    const formValues = this.contactForm.value;


      this.contact = new ContactModel(
        formValues['nom'],
        formValues['prenom'],
        formValues['dateNaissance'],
        formValues['telephone'],
        formValues['pathImage']
      );




     this.contactService.addContact(this.contact);
     // this.route.navigate(['/contacts']);
    this.mode = 2;
  }




}
