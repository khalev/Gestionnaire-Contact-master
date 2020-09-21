import { Component, OnInit } from '@angular/core';
import {ContactModel} from '../models/contact.model';
import {ContactsServices} from '../services/contacts.services';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-edit-contact',
  templateUrl: './edit-contact.component.html',
  styleUrls: ['./edit-contact.component.css']
})
export class EditContactComponent implements OnInit {
   mode = 1;
   contact:ContactModel;
   contactForm:FormGroup;
   public id:number;
  constructor(public contactService:ContactsServices,
              public activateRouter:ActivatedRoute) { }

  ngOnInit() {
  //  this.contactService.initForm();
      this.contactForm = this.contactService.contactForm;
      this.contact = this.contactService.contact;
      this.id = this.activateRouter.snapshot['id'];
  }

  editContact(id:number){

  }

}
