package jady.test;

import lombok.Data;

import java.util.List;

/**
 * Created by liuhan on 2019/9/24.
 */
@Data
public class CompanyModel {
    private String companyCode;
    private String companyDesc;
    private String companyName;
    private Long id;
    private String status;
    private List<String> list;
    private UserForTest userForTest;
}
