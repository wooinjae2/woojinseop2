package travelstudio.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travelstudio.dao.MemberDao;
import travelstudio.domain.Member;
import travelstudio.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
  @Autowired MemberDao memberDao;
  
 
  public void add(Member member) throws Exception {
    memberDao.insert(member);
    
  }
  
  public Member getByEmailPassword(String email, String password) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("email", email);
    valueMap.put("password", password);
    
    return memberDao.selectOneByEmailPassword(valueMap);
  }
  
  public List<Member> list() throws Exception {
    return memberDao.selectList();
  }
  
//  
//  public Teacher get(int no) throws Exception {
//    return teacherDao.selectOne(no);
//  }
//  
//  public Teacher getByEmailPassword(String email, String password) throws Exception {
//    HashMap<String,Object> valueMap = new HashMap<>();
//    valueMap.put("email", email);
//    valueMap.put("password", password);
//    
//    return teacherDao.selectOneByEmailPassword(valueMap);
//  }
  
//  @Override
//  public int getSize() throws Exception {
//    return noticeDao.countAll();
//  }
  
//  // XML 태그로 트랜잭션을 설정하게 되면 @Transactional 애노테이션은 필요없다.
//  //@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
//  public void add(Teacher teacher) throws Exception {
//    memberDao.insert(teacher);
//    teacherDao.insert(teacher);
//    this.insertPhoto(teacher.getNo(), teacher.getPhotoList()); // 강사 사진 추가
//  }
//  
//  //XML 태그로 트랜잭션을 설정하게 되면 @Transactional 애노테이션은 필요없다.
//  //@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
//  public void update(Teacher teacher) throws Exception {
//    int count = memberDao.update(teacher);
//    if (count < 1) {
//      throw new Exception(teacher.getNo() + "번 강사를 찾을 수 없습니다.");
//    }
//    
//    count = teacherDao.update(teacher);
//    if (count < 1) {
//      throw new Exception(teacher.getNo() + "번 강사를 찾을 수 없습니다.");
//    }
//    
//    // 강사 사진 갱신
//    teacherDao.deletePhoto(teacher.getNo()); // 강사의 모든 사진을 지운다.
//    this.insertPhoto(teacher.getNo(), teacher.getPhotoList()); // 강사 사진 추가
//  }
//  
//  private void insertPhoto(int teacherNo, List<String> photoPathList) {
//    if (photoPathList == null)
//      return;
//    
//    HashMap<String,Object> valueMap = new HashMap<>();
//    valueMap.put("teacherNo", teacherNo);
//    
//    for (String photoPath : photoPathList) {
//      valueMap.put("photoPath", photoPath);
//      teacherDao.insertPhoto(valueMap);
//    }
//  }
//  
//  //XML 태그로 트랜잭션을 설정하게 되면 @Transactional 애노테이션은 필요없다.
//  //@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
//  public void remove(int no) throws Exception {
//    teacherDao.deletePhoto(no);
//    int count = teacherDao.delete(no);
//    if (count < 1) {
//      throw new Exception(no + "번 강사를 찾을 수 없습니다.");
//    }
//    
//    try {
//      count = memberDao.delete(no);
//    } catch (Exception e) {}
//  }
}







