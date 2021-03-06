package mybatis.dao;

import java.util.List;
import mybatis.model.Suniukas;
import org.mybatis.cdi.Mapper;

@Mapper
public interface SuniukasMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Suniukas
     *
     * @mbg.generated Thu Mar 30 00:59:06 EEST 2017
     */
    int deleteByPrimaryKey(String gyvunoid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Suniukas
     *
     * @mbg.generated Thu Mar 30 00:59:06 EEST 2017
     */
    int insert(Suniukas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Suniukas
     *
     * @mbg.generated Thu Mar 30 00:59:06 EEST 2017
     */
    Suniukas selectByPrimaryKey(String gyvunoid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Suniukas
     *
     * @mbg.generated Thu Mar 30 00:59:06 EEST 2017
     */
    List<Suniukas> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Suniukas
     *
     * @mbg.generated Thu Mar 30 00:59:06 EEST 2017
     */
    int updateByPrimaryKey(Suniukas record);
}