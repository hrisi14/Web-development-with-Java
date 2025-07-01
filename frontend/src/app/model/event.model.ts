export interface Event {
  id?: number;
  title: string;
  description: string;
  category: string;
  location: string;
  imageUrl: string | null;
  startDate: string;
  endDate: string;
  rules: string;
  likes?: number;
  followers?: number;
  visitors?: number;
  organizerId?: number | null;
  sponsorId?: number | null;
}
