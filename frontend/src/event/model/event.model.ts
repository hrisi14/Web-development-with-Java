export interface Event {
  id?: number;
  title: string;
  description: string;
  category: string;
  location: string;
  startDate: string;
  endDate: string;
  rules: string;
  likes?: number;
  followers?: number;
  visitors?: number;
  imageUrl?: string;
  organizerId?: number | null;
  sponsorId?: number | null;
}
