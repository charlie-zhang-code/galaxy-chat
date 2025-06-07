package io.github.charlie.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author charlie-zhang-code
 * @version v1.0
 * @date 2025/4/13
 * @description 分页返回结果
 */
@Data
public class PageResult<T> implements Serializable {
    private String code;

    private Data<T> data;

    private String message;

    private Boolean success;

    public static <T> PageResult<T> success(IPage<T> page) {
        PageResult<T> result = new PageResult<>();
        result.setCode(ResultCode.SUCCESS.getCode());

        Data<T> data = new Data<>();
        data.setRecords(page.getRecords());
        data.setTotal(page.getTotal());
        data.setSize(page.getSize());
        data.setCurrent(page.getCurrent());
        data.setPages(page.getPages());
        result.setData(data);

        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setSuccess(true);

        return result;
    }

    public static <T> PageResult<T> success(Data<T> data) {
        PageResult<T> result = new PageResult<>();
        result.setCode(ResultCode.SUCCESS.getCode());

        result.setData(data);

        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setSuccess(true);

        return result;
    }

    @lombok.Data
    public static class Data<T> {

        private List<T> records;

        private Long pages;

        private Long total;

        private Long size;

        private Long current;
    }

    @Serial
    private static final long serialVersionUID = 1L;
}
