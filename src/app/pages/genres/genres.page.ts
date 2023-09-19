import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Genre } from 'src/app/interfaces/genre';

@Component({
  selector: 'app-genres',
  templateUrl: './genres.page.html',
  styleUrls: ['./genres.page.scss'],
})
export class GenresPage implements OnInit {

  genres: Genre[] = [
    {
      name: 'Pop',
      image: 'pop.jpg',
      tag: 'pop'
    },
    {
      name: 'Country',
      image: 'country.jpg',
      tag: 'country'
    },
    {
      name: 'Rock',
      image: 'rock.jpg',
      tag: 'rock'
    },
    {
      name: 'Metal',
      image: 'metal.jpg',
      tag: 'metal'
    },
    {
      name: 'Jazz',
      image: 'jazz.jpg',
      tag: 'jazz'
    },
    {
      name: 'Hip Hop',
      image: 'hiphop.jpg',
      tag: 'hiphop'
    },
    {
      name: 'Indie',
      image: 'indie.jpg',
      tag: 'indie'
    },
    {
      name: 'Lo Fi',
      image: 'lofi.jpg',
      tag: 'lofi'
    },
    {
      name: 'Classic',
      image: 'classic.jpg',
      tag: 'classic'
    },
    {
      name: 'Reggae',
      image: 'reggae.jpg',
      tag: 'reggae'
    }
  ]

  constructor(
    private router: Router
  ) { }

  ngOnInit() {
  }

  gotoHome() {
    this.router.navigate(['/'])
  }

}
