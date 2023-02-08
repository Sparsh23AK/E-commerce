import { Component } from '@angular/core';
import { Pipe, PipeTransform } from '@angular/core';

@Component({
  selector: 'app-cardscomp',
  templateUrl: './cardscomp.component.html',
  styleUrls: ['./cardscomp.component.css']
})

export class CardscompComponent {
  frontendData=[
    {title:'Our Category', cardInfo:[{cardTitle:'Men', cardText:'Some quick example text to build on the card title and make up the bulk of the cards content.' , cardHref:'#link'},
                                      {cardTitle:'Men', cardText:'Some quick example text to build on the card title and make up the bulk of the cards content.' , cardHref:'#link'},
                                      {cardTitle:'Men', cardText:'Some quick example text to build on the card title and make up the bulk of the cards content.' , cardHref:'#link'}]},
    {title:'Men', cardInfo:[{cardTitle:'Latest trend', cardText:'Some quick example text to build on the card title and make up the bulk of the cards content.' , cardHref:'#link'},
                            {cardTitle:'Latest trend', cardText:'Some quick example text to build on the card title and make up the bulk of the cards content.' , cardHref:'#link'},
                            {cardTitle:'Latest trend', cardText:'Some quick example text to build on the card title and make up the bulk of the cards content.' , cardHref:'#link'},
                            {cardTitle:'Latest trend', cardText:'Some quick example text to build on the card title and make up the bulk of the cards content.' , cardHref:'#link'}]}
    // {title:'Women', cardTitle:'Latest trend', cardText:'Some quick example text to build on the card title and make up the bulk of the cards content.', cardHref:'#link'},
    // {title:'Kids', cardTitle:'Latest trend', cardText:'Some quick example text to build on the card title and make up the bulk of the cards content.', cardHref:'#link'},
    // {title:'Home & Living', cardTitle:'Latest trend', cardText:'Some quick example text to build on the card title and make up the bulk of the cards content.', cardHref:'#link'}
  ]

  // category=['Men','Women','Kids','Home & Living']
  // menClothes=['Shirt','Shirt','Shirt','Shirt','Shirt','Shirt']
}
