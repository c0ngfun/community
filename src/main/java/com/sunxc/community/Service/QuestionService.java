package com.sunxc.community.Service;

import com.sunxc.community.dto.PaginationDTO;
import com.sunxc.community.dto.QuestionDTO;
import com.sunxc.community.mapper.QuestionMapper;
import com.sunxc.community.mapper.UserMapper;
import com.sunxc.community.model.Question;
import com.sunxc.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectname:community
 * @classname:QuestionService
 * @description:service层可以使用qustionmapper和usermapper，起到了组装的作用，当一个请求需要组装user的时候，
 * 也需要组装question的时候，就需要一个中间层来实现这个功能
 * @auhtor: sunxc
 * @date: 2019/12/30-15:43
 * @version: 1.0
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    public PaginationDTO list(Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);

        if(page<1){
            page=1;
        }
        if(page>paginationDTO.getTotalPage()){
            page=paginationDTO.getTotalPage();
        }
        //size*(page-1)
         Integer offset=size*(page-1);
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for (Question question:questions){
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }
}
