package CryptOptima.server.domain.exchange.service;

import CryptOptima.server.domain.exchange.dto.ExchangeDto;

import java.util.List;

public interface ExchangeService {
    ExchangeDto.Response createEcxhange(ExchangeDto.Create exchangeDto);
    ExchangeDto.Response updateExchange(ExchangeDto.Update exchangeDto, Long exchangeId);
    ExchangeDto.Response getExchangeById(Long exchangeId);
    List<ExchangeDto.Response> getExchanges(int page, int size);
    void deleteExchange(Long exchangeId);
}