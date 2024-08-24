package in.ashokit.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.Passenger;
import in.ashokit.bindings.Ticket;
import in.ashokit.service.TicketService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class TicketRestController {
	
	@Autowired
	private TicketService service;
	
     @PostMapping("/ticket")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger p){
		Ticket ticket = service.bookTicket(p);
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
     
     @GetMapping("/ticketss")
     public ResponseEntity<Collection<Ticket>>getTickets(){
    	 Collection<Ticket> allTickets = service.getAllTickets();
    	 return new ResponseEntity<>(allTickets,HttpStatus.OK);
     }
     

}
