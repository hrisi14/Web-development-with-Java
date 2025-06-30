// src/app/models/event.model.ts
export interface Event {
  id: number;
  title: string;
  description: string;
  category: string;
  location: string;
  startDate: string;
  endDate: string;
  rules: string;
  likes: number;
  imageUrl: string;
}
