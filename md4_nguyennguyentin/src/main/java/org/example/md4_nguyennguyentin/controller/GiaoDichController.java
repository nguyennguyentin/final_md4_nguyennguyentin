package org.example.md4_nguyennguyentin.controller;


import org.example.md4_nguyennguyentin.entity.GiaoDich;
import org.example.md4_nguyennguyentin.service.GiaoDichService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/giaodich")
public class GiaoDichController {
    private final GiaoDichService service;

    public GiaoDichController(GiaoDichService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        List<GiaoDich> giaoDichList = service.getAll();
        model.addAttribute("giaoDichList", giaoDichList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("giaoDich", new GiaoDich());
        return "add";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute GiaoDich giaoDich) {
        service.save(giaoDich);
        return "redirect:/giaodich/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/giaodich/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam String ten, @RequestParam String loai, Model model) {
        List<GiaoDich> giaoDichList = service.search(ten, loai);
        model.addAttribute("giaoDichList", giaoDichList);
        return "index";
    }
}
