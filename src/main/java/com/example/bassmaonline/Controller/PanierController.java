//package com.example.bassmaonline.Controller;
//
//
//import com.example.bassmaonline.entity.CategoriesEntity;
//import com.example.bassmaonline.entity.PanierEntity;
//import com.example.bassmaonline.service.PanierService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/panier")
//public class PanierController {
//
//    @Autowired
//    PanierService panierService;
//
//    @PostMapping
//    public ResponseEntity<PanierEntity> createCatePanier(@RequestBody PanierEntity panierEntity) {
//        PanierEntity panierEntity1 = panierService.createPanier(panierEntity);
//        return new ResponseEntity<>(panierEntity1, HttpStatus.CREATED);
//    }
//
//    @PutMapping(path = "/{panierId}")
//    public ResponseEntity<PanierEntity>  UpdatePanier(@RequestBody PanierEntity panierEntity, @PathVariable Long panierId){
//       PanierEntity panierEntity1 = panierService.updatePanier(panierId,panierEntity);
//        return new ResponseEntity<>(panierEntity1, HttpStatus.ACCEPTED);
//    }
//
//    @DeleteMapping("/Removecat/{panierId}")
//    public ResponseEntity<CategoriesEntity> removePaniers(@PathVariable Long panierId) {
//        panierService.deletePanier(panierId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//
//    @GetMapping("/Paniers")
//    public List<PanierEntity> findAlPaniers() {
//        return panierService.getAllPanier();
//    }
//
//    @GetMapping("/getPanierById/{panierId}")
//    public ResponseEntity<PanierEntity> findPaniersById(@PathVariable Long panierId) {
//       PanierEntity panierEntity=panierService.getPanierById(panierId);
//        return new ResponseEntity<>(panierEntity, HttpStatus.OK);
//    }
//
//
//
//
//}
