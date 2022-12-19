package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.KhoangSan;
import net.javaguides.springboot.repository.KhoangSanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class KhoangSanController {

	@Autowired
	private KhoangSanRepository repository;
	
	// get all
	@GetMapping("/khoangsan")
	public List<KhoangSan> getAllKhoangSans(){
		return repository.findAll();
	}		
	
	// create rest api
	@PostMapping("/khoangsan")
	public KhoangSan createKhoangSan(@RequestBody KhoangSan khoangsan) {
		return repository.save(khoangsan);
	}
	
	// get by id rest api
	@GetMapping("/khoangsan/{id}")
	public ResponseEntity<KhoangSan> getKhoangSanById(@PathVariable Long id) {
		KhoangSan khoangsan = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Khoang San not exist with id :" + id));
		return ResponseEntity.ok(khoangsan);
	}
	
	// update rest api
	
	@PutMapping("/khoangsan/{id}")
	public ResponseEntity<KhoangSan> updateKhoangSan(@PathVariable Long id, @RequestBody KhoangSan khoangSan){
		KhoangSan _khoangsan = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("KhoangSan not exist with id :" + id));
		
		_khoangsan.setTenKhoangSan(khoangSan.getTenKhoangSan());
		_khoangsan.setDiaChiMoKs(khoangSan.getDiaChiMoKs());
		_khoangsan.setTenMoKs(khoangSan.getTenMoKs());
		_khoangsan.setTruLuong(_khoangsan.getTruLuong());
		_khoangsan.setMaKs(id);
		KhoangSan updatedKhoangSan = repository.save(_khoangsan);
		return ResponseEntity.ok(updatedKhoangSan);
	}
	
	// delete employee rest api
	@DeleteMapping("/khoangsan/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteKhoangSan(@PathVariable Long id){
		KhoangSan khoangsan = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("KhoangSan not exist with id :" + id));
		
		repository.delete(khoangsan);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
