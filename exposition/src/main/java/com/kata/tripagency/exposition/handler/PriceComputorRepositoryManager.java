package com.kata.tripagency.exposition.handler;

import com.kata.tripagency.domain.port.repositories.TicketFeesRepositoryPort;
import com.kata.tripagency.domain.port.repositories.TripRepositoryPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PriceComputorRepositoryManager {

    private final TripRepositoryPort tripRepositoryJdbcTemplateAdapter;

    private final TripRepositoryPort tripRepositoryJpaAdapter;

    private final TicketFeesRepositoryPort ticketFeesRepositoryPort;

    public PriceComputorRepositoryManager(
            @Qualifier("TripRepositoryJdbcTemplateAdapter") final TripRepositoryPort tripRepositoryJdbcTemplateAdapter,
            @Qualifier("TripRepositoryJpaAdapter") final TripRepositoryPort tripRepositoryJpaAdapter,
            @Qualifier("TicketFeesRepositoryJpaAdapter") final TicketFeesRepositoryPort ticketFeesRepositoryPort) {
        this.tripRepositoryJdbcTemplateAdapter = tripRepositoryJdbcTemplateAdapter;
        this.tripRepositoryJpaAdapter = tripRepositoryJpaAdapter;
        this.ticketFeesRepositoryPort = ticketFeesRepositoryPort;
    }

    public TripRepositoryPort getTripRepositoryAdapter(final RepositoryType repositoryType) {
        switch (repositoryType) {
            case JDBC_TEMPLATE:
                return tripRepositoryJdbcTemplateAdapter;
            default:
                return tripRepositoryJpaAdapter;
        }
    }

    public TicketFeesRepositoryPort getTicketFeesRepositoryPort(final RepositoryType repositoryType) {
            return ticketFeesRepositoryPort;
        }
}
