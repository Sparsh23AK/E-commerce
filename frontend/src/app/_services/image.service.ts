import { Injectable } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

export interface FileHandle{
  file : File,
  url : SafeUrl
}

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  constructor(private sanitizer: DomSanitizer) { }

  public createImage(productDetails : any[]){

    for(let i =0; i< productDetails.length; i++){
      const imageData = productDetails[i].imageData;
      const imageType = productDetails[i].imageType;

      const imageBlob = this.dataURItoBlob(imageData, imageType);

      const imageFile = new File([imageBlob], productDetails[i].imageName, {type: imageType});

      const fileHandle : FileHandle = {
        file : imageFile,
        url : this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(imageFile))
      };
      productDetails[i].imageData = fileHandle;
    }
    return productDetails;

  }

  public dataURItoBlob(imageByte : any, imageType : any){
    const byteString = window.atob(imageByte);
    const arrayBuffer = new ArrayBuffer(byteString.length);
    const int8Array = new Uint8Array(arrayBuffer);

    for(let i =0; i< byteString.length; i++){
      int8Array[i] = byteString.charCodeAt(i);
    }
    return new Blob([int8Array], {type : imageType});

  }
}
