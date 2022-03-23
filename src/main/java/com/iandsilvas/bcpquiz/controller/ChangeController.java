package com.iandsilvas.bcpquiz.controller;

import com.iandsilvas.bcpquiz.controller.dto.ChangeDTO;
import com.iandsilvas.bcpquiz.domain.Change;
import com.iandsilvas.bcpquiz.repository.ChangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/change")
public class ChangeController {

    Logger logger = LoggerFactory.getLogger(ChangeController.class);

    @Autowired
    ChangeRepository changeRepository;

    @GetMapping()
    public ResponseEntity<List<Change>> getAllChanges() {
        List<Change> changes = new ArrayList<Change>();
        changeRepository.findAll().forEach(changes::add);
        return new ResponseEntity<List<Change>>(changes, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Change> registerChange(@RequestBody ChangeDTO change) {
        try {
            Change _change = changeRepository
                    .save(new Change(change.getName(), change.getValue()));
            return new ResponseEntity<>(_change, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Change> updateChange(@PathVariable("id") Integer id, @RequestBody() ChangeDTO change) {
        try {
            logger.info("Buscando por {}", id);
            Optional<Change> tutorialData = changeRepository.findById(id);
            if(tutorialData.isPresent()) {
                Change _change = tutorialData.get();
                _change.setName(change.getName());
                _change.setValue(change.getValue());
                return new ResponseEntity<Change>(changeRepository.save(_change), HttpStatus.OK);
            }
        }catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
