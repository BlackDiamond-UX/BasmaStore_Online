package com.example.bassmaonline.Controller;

import com.example.bassmaonline.entity.PicturesEntity;
import com.example.bassmaonline.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pictures")
public class PicturesController {
    @Autowired
     PicturesService picturesService;

    @PostMapping
    public ResponseEntity<PicturesEntity> createPictures(@RequestBody PicturesEntity picturesEntity)
    {
        PicturesEntity pictures=picturesService.createPictures(picturesEntity);
        return new ResponseEntity<>(pictures, HttpStatus.CREATED);
    }

    @PutMapping ("/{PictId}")
    public ResponseEntity<PicturesEntity> UpdatePictures(@RequestBody PicturesEntity picturesEntity,@PathVariable Long PictId)
    {
       PicturesEntity pictures=picturesService.updatePictures(PictId,picturesEntity);
       return new ResponseEntity<>(pictures,HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/getAllPictures")
    public ResponseEntity<PicturesEntity> getAllPictures()
    {
       List<PicturesEntity> picturesEntityList= picturesService.getAllPictures();
        return new ResponseEntity(picturesEntityList,HttpStatus.OK);
    }

    @GetMapping("/getPicturesById/{idPict}")
    public ResponseEntity<PicturesEntity> findPicturesById(@PathVariable Long idPict)
    {
        PicturesEntity pictures=picturesService.getPictures(idPict);
        return new ResponseEntity<>(pictures,HttpStatus.OK);
    }
}
