package com.fetchrewards.receiptprocessor.controller;

import com.fetchrewards.receiptprocessor.service.ReceiptService;
import com.fetchrewards.receiptprocessor.model.Receipt;
import com.fetchrewards.receiptprocessor.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    @Autowired
    private ReceiptRepository receiptRepository;

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptRepository receiptRepository, ReceiptService receiptService) {
        this.receiptRepository = receiptRepository;
        this.receiptService = receiptService;
    }


    @PostMapping("/process")
    public ResponseEntity<String> processReceipt(@RequestBody Receipt receipt){
        Receipt savedReceipt = receiptService.saveReceipt(receipt);
        return ResponseEntity.ok("{\"id\": \"" + savedReceipt.getId() + "\" }");
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<String> getPoints(@PathVariable UUID id) {
//        System.out.println("here!!");
        Optional<Receipt> optionalReceipt = receiptRepository.findById(id);
        if (optionalReceipt.isPresent()) {
            Receipt receipt = optionalReceipt.get();
            String points = receiptService.calculatePoints(receipt);
            return ResponseEntity.ok("{ \"points\": " + points + " }");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
