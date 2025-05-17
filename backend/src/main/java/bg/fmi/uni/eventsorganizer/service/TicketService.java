package bg.fmi.uni.eventsorganizer.service;

import bg.fmi.uni.eventsorganizer.dto.TicketDto;
import bg.fmi.uni.eventsorganizer.model.Ticket;
import bg.fmi.uni.eventsorganizer.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public List<TicketDto> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public Optional<TicketDto> getTicketById(Integer id) {
        return ticketRepository.findById(id).map(this::toDto);
    }

    public TicketDto createTicket(TicketDto ticketDto) {
        Ticket ticket = toEntity(ticketDto);
        return toDto(ticketRepository.save(ticket));
    }

    public boolean updateTicket(Integer id, TicketDto ticketDto) {
        if (ticketRepository.existsById(id)) {
            Ticket ticket = toEntity(ticketDto);
            ticket.setId(id);
            ticketRepository.save(ticket);
            return true;
        }
        return false;
    }

    public boolean deleteTicket(Integer id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private TicketDto toDto(Ticket ticket) {
        return new TicketDto(
                ticket.getId(),
                ticket.getEventId(),
                ticket.getPrice()
        );
    }

    private Ticket toEntity(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDto.id());
        ticket.setEventId(ticketDto.eventId());
        ticket.setPrice(ticketDto.price());
        return ticket;
    }
}