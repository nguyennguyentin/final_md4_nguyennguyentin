package org.example.md4_nguyennguyentin.controller;

import lombok.Getter;
import org.example.md4_nguyennguyentin.entity.GiaoDich;
import org.example.md4_nguyennguyentin.entity.KhachHang;
import org.example.md4_nguyennguyentin.service.GiaoDichService;
import org.example.md4_nguyennguyentin.service.KhachHangService;
import org.example.md4_nguyennguyentin.service.LoaiDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/giaodich")
public class GiaoDichController {
    @Autowired
    private GiaoDichService giaoDichService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private LoaiDichVuService loaiDichVuService;

    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(value = "tenKhachHang",required = false)String tenKhachHang,
                           @RequestParam(value = "loaiDichVu",required = false)String loaiDichVu) {
        List<GiaoDich>giaoDichList ;
        if((tenKhachHang==null || tenKhachHang.isEmpty()) && (loaiDichVu==null || loaiDichVu.isEmpty())) {
            giaoDichList = giaoDichService.getAll();
        }else {
            giaoDichList = giaoDichService.search(tenKhachHang,loaiDichVu);
        }
        model.addAttribute("giaoDichList", giaoDichList);
        return "giaodich/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("giaoDich", new GiaoDich());
        model.addAttribute("khachHangList", khachHangService.getAll());
        model.addAttribute("loaiDichVuList", loaiDichVuService.getAll());
        return "giaodich/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("giaoDich")GiaoDich giaoDich,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        System.out.println("Dữ liệu nhận được: " + giaoDich);
        System.out.println("Mã giao dịch: " + giaoDich.getMaGiaoDich());
        System.out.println("Khách hàng: " + (giaoDich.getKhachHang() != null ? giaoDich.getKhachHang().getMaKhachHang() : "NULL"));
        System.out.println("Loại dịch vụ: " + (giaoDich.getLoaiDichVu() != null ? giaoDich.getLoaiDichVu().getMaLoaiDichVu() : "NULL"));
        System.out.println("Ngày giao dịch: " + giaoDich.getNgayGiaoDich());
        System.out.println("Đơn giá: " + giaoDich.getDonGia());
        System.out.println("Diện tích: " + giaoDich.getDienTich());

        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("khachHangList", khachHangService.getAll());
            model.addAttribute("loaiDichVuList", loaiDichVuService.getAll());
            return "giaodich/create";
        }

        giaoDichService.save(giaoDich);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/giaodich/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") String id, Model model) {
        GiaoDich giaoDich = giaoDichService.findById(id);
        if (giaoDich == null) {
            return "redirect:/giaodich/list";
        }
        model.addAttribute("giaoDich", giaoDich);
        return "giaodich/detail";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGiaoDich(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        GiaoDich giaoDich = giaoDichService.findById(id);
        if (giaoDich != null) {
            giaoDichService.remove(id);
            redirectAttributes.addFlashAttribute("successMessage", "Xóa giao dịch thành công!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Giao dịch không tồn tại!");
        }
        return "redirect:/giaodich/list";
    }

}
