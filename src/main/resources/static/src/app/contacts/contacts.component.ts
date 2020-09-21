import {Component, OnDestroy, OnInit} from '@angular/core';
import {ContactsServices} from '../services/contacts.services';
import {Subscription} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {ContactModel} from '../models/contact.model';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent implements OnInit,OnDestroy {
   pageContacts:any;
  contactSubcription:Subscription;
  motCle:string ="";
  pageCourante:number=0;
  size:number=4;
  pages:Array<number>;

  constructor(public contactsService:ContactsServices,
              public http:HttpClient,
              public router:Router) { }

  ngOnInit() {
  this.doSercher();
  }

  onEdit(c:ContactModel){
      this.router.navigate(['/edit-contact',c.id]);
  }

  doSercher(){
    this.contactSubcription = this.contactsService.getContacts(this.motCle,this.pageCourante,this.size).subscribe(
      (resp:any)=>{
        this.pageContacts = resp;
        this.pages = new Array<number>(resp.totalPages);
      },
      (error)=>{
        console.log("Erreur : "+error);
      }
    );
  }

  goToPage(i:number){
    this.pageCourante=i;
    this.doSercher();
  }

  onSubmitSearch(){
    this.doSercher();
  }

  ngOnDestroy(){
   // this.contactSubcription.unsubscribe();
  }

}
