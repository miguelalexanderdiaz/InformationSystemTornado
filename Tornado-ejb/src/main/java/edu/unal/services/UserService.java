

package edu.unal.services;

import edu.unal.dto.UserDTO;
import edu.unal.factory.DAOFactory;
import edu.unal.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author migueldiaz
 */
@Service
public class UserService {
    edu.unal.dao.implementation.UserDAO userDAO;

    public UserService() {
        DAOFactory factory=DAOFactory.getInstance();
        this.userDAO=factory.getUserDAO();
    }
    
    public void save(UserDTO dto){
        userDAO.save(dto.dtoToModel());
    }
    
    public void delete(UserDTO dto){
        User user=userDAO.findByName(dto.dtoToModel());
        userDAO.delete(user);
    }
    
    public UserDTO findByName(UserDTO dto){
        UserDTO found = new UserDTO();
        found.modeltToDTO(userDAO.findByName(dto.dtoToModel()));
        return found;
    }
    
    public UserDTO findById(UserDTO dto){
        UserDTO found = new UserDTO();
        found.modeltToDTO(userDAO.findById(dto.dtoToModel()));
        return found;
    }
    
    public UserDTO findOne(UserDTO dto){
        UserDTO found = new UserDTO();
        User model = userDAO.findOne(dto.dtoToModel());
        if(model!=null){
                    return found.modeltToDTO(model);
        }
        else{
            System.out.println("NO EXISTE");
            return null;
        }
    }
    public List<UserDTO> findAll(){
        List<User> users = userDAO.findAll();
        List<UserDTO> foundUsers=new ArrayList<>();

        for (User user : users) {
            UserDTO userDTOTemp = new UserDTO();
            foundUsers.add(userDTOTemp.modeltToDTO(user));
        }
        return foundUsers;
    }
    
    public void deleteAll(){
        userDAO.deleteAll();
    }
    
    public void update(UserDTO oldUser, UserDTO newUser){
        userDAO.update(oldUser.dtoToModel(),newUser.dtoToModel());
    } 
}
