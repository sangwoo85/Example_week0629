package dao;

import Annotation.Component;
import vo.Member;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component("memberDao")
public class MySqlMemberDao implements MemberDao{
    DataSource ds;

    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    public List<Member> selectList() throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT mno,mname,email,cre_date FROM members ORDER BY mno ASC ");

            ArrayList<Member> members = new ArrayList<Member>();
            while(rs.next()) {

                members.add(new Member().setMno(rs.getInt("mno"))
                        .setMname(rs.getString("mname"))
                        .setEmail(rs.getString("email"))
                        .setCre_date(rs.getDate("cre_date")));
            }
        return members;
        }catch(Exception e){
            throw e;
        }finally{
            try{
                if(rs !=null)rs.close();
                if(stmt !=null)stmt.close();
                if(conn !=null)conn.close();
            }catch(Exception e){}

        }

    }

    @Override
    public int insert(Member member) throws Exception {
        return 0;
    }

    @Override
    public int delete(int no) throws Exception {
        return 0;
    }

    @Override
    public Member selectOne(int no) throws Exception {
        return null;
    }

    @Override
    public int update(Member member) throws Exception {
        return 0;
    }

    @Override
    public Member exist(String email, String password) throws Exception {
        return null;
    }
}
