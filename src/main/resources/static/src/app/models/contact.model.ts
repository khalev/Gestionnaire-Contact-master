

export  class ContactModel {



  constructor(
    public id:any,
    public nom:string="",
    public prenom:string="",
    public dateNaissance:string="",
    public telephone:string="",
    public imagePath:string=nom+".jpg"
  ){

  }

}
