import { Injectable } from '@angular/core';
import { BlogPost } from './blog-post';

@Injectable({
  providedIn: 'root'
})
export class BlogDataService {

  constructor() { }

  getData(): BlogPost[][] {
    return [
      // Page 1
      [
        {
          title: 'Post 1',
          summary: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.'
        },
        {
          title: 'Post 2',
          summary: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.'
        },
        {
          title: 'Post 3',
          summary: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.'
        },
        {
          title: 'Post 4',
          summary: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.'
        }
      ],
      // Page 2
      [
        {
          title: 'Post 5',
          summary: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.'
        },
        {
          title: 'Post 6',
          summary: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.'
        },
        {
          title: 'Post 7',
          summary: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.'
        },
        {
          title: 'Post 8',
          summary: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.'
        }
      ],
      // Page 3
      [
        {
          title: 'Post 9',
          summary: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.'
        },
        {
          title: 'Post 10',
          summary: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.'
        },
        {
          title: 'Post 11',
          summary: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.'
        },
        {
          title: 'Post 12',
          summary: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.'
        }
      ]
    ];
  }
}
