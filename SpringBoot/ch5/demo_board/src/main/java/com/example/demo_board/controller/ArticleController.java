package com.example.demo_board.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo_board.dto.ArticleDto;
import com.example.demo_board.dto.ArticleForm;
import com.example.demo_board.model.MemberUserDetails;
import com.example.demo_board.service.ArticleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/list")
    public String getArticleList(
            @PageableDefault(size = 10) Pageable pageable,
            Model model
    ) {
        Page<ArticleDto> page = articleService.findAll(pageable);
        model.addAttribute("page", page);
        return "article-list";
    }

    @GetMapping("/content")
    public String getArticle(@RequestParam("id") Long id, Model model) {
        model.addAttribute("article", articleService.findById(id));
        return "article-content";
    }

    @GetMapping("/add")
    public String getArticleAdd(Model model) {
        model.addAttribute("article", new ArticleForm());
        return "article-add";
    }

    // @PostMapping("/add")
    // public String postArticleAdd(@ModelAttribute("article") ArticleForm articleForm, 
    //                              @AuthenticationPrincipal MemberUserDetails userDetails) {
    //     articleService.create(userDetails.getMemberId(), articleForm);
    //     return "redirect:/article/list";
    // }

    @PostMapping("/add")
    public String postArticleAdd(@Valid @ModelAttribute("article") ArticleForm articleForm,
                                 BindingResult bindingResult,
                                 @AuthenticationPrincipal MemberUserDetails userDetails) {

        if (articleForm.getTitle() != null && articleForm.getTitle().contains("T발")) {
            bindingResult.rejectValue("title", "SlangDetected", "욕설을 사용하지 마세요");
        }
        if (articleForm.getDescription() != null && articleForm.getDescription().contains("T발")) {
            bindingResult.rejectValue("description", "SlangDetected", "욕설을 사용하지 마세요");
        }

        if (bindingResult.hasErrors()) {
            return "article-add";
        }

        articleService.create(userDetails.getMemberId(), articleForm);
        return "redirect:/article/list";
    }

    @GetMapping("/edit")
    public String getArticleEdit(@RequestParam("id") Long id, 
                                 @ModelAttribute("article") ArticleForm articleForm, 
                                 Model model) {
        ArticleDto articleDto = articleService.findById(id);
        articleForm.setId(articleDto.getId());
        articleForm.setTitle(articleDto.getTitle());
        articleForm.setDescription(articleDto.getDescription());
        return "article-edit";
    }

    @PostMapping("/edit")
    public String postArticleEdit(@Valid @ModelAttribute("article") ArticleForm articleForm,
                                  BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "article-edit";
        }
        articleService.update(articleForm);
        return "redirect:/article/content?id=" + articleForm.getId();
    }
}