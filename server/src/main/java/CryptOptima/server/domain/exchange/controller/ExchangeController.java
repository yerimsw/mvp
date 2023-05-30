package CryptOptima.server.domain.exchange.controller;

import CryptOptima.server.domain.exchange.service.ExchangeService;
import CryptOptima.server.domain.exchange.dto.ExchangeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/server/exchanges")
public class ExchangeController {

    private final ExchangeService exchangeService;

    // 1. 거래소 등록
    @PostMapping
    ResponseEntity createExchange(@RequestBody ExchangeDto.Create exchangeDto) {
        ExchangeDto.Response response = exchangeService.createEcxhange(exchangeDto);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    // 2. 거래소 정보 수정
    @PatchMapping("/{exchange-id}")
    ResponseEntity updateExchange(@PathVariable("exchange-id") Long exchangeId,
                                  @RequestBody ExchangeDto.Update exchangeDto) {
        ExchangeDto.Response response = exchangeService.updateExchange(exchangeDto,exchangeId);
        return new ResponseEntity(response, HttpStatus.OK);
    }


    // 3. 거래소 조회
    @GetMapping("/{exchange-id}")
    ResponseEntity getExchange(@PathVariable("exchange-id") Long exchangeId) {
        ExchangeDto.Response response = exchangeService.getExchangeById(exchangeId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity getExchanges(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value ="size", defaultValue = "20") int size) {
        List<ExchangeDto.Response> response = exchangeService.getExchanges(page-1, size);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    // 4. 거래소 삭제
    @DeleteMapping("/{exchange-id}")
    ResponseEntity deleteExchanges(@PathVariable("exchange-id") Long exchangeId) {
        exchangeService.deleteExchange(exchangeId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
