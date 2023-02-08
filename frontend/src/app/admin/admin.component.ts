import { Component } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  // fileChosen:File = new File();

  onChange(event:any){
    console.log(event.target.files);
    // console.log(this.fileChosen);
  }
}
