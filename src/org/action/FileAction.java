package org.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dao.DepartmentDao;
import org.dao.FileDao;
import org.dao.FileauthorityDao;
import org.dao.PeopleDao;
import org.dao.impl.DepartmentDaoImp;
import org.dao.impl.FileDaoImp;
import org.dao.impl.FileauthorityDaoImp;
import org.dao.impl.PeopleDaoImp;
import org.model.Department;
import org.model.File1;
import org.model.Fileauthority;
import org.model.FileauthorityId;
import org.model.People;
import org.tool.GetFileName;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport {
	private List<File> upload; // 上传的文件内容，由于是多个用List集合
	private List<String> uploadFileName; // 文件名
	private File1 file1;
	// private List<String> checkBox;
	private String checkBox;
	private String message;
	private String inputPath;
	private String filename = "email.zip";
	private int pageSize = 8;
	private int pageNow = 1;
	private String fullName;
	private String searchName;
	private String newFolder;
	private String newFoldName;
	private int tempId;

	public void setTempId(int tempId) {
		this.tempId = tempId;
	}

	public int getTempId() {
		return this.tempId;
	}

	public void setNewFoldName(String newFoldName) {
		this.newFoldName = newFoldName;
	}

	public String getNewFoldName() {
		return this.newFoldName;
	}

	public void setNewFolder(String newFolder) {
		// GetFileName a=new GetFileName();
		// String b=a.getDownloadChineseFileName(newFolder);
		this.newFolder = newFolder;
	}

	public String getNewFolder() {
		return this.newFolder;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchName() {
		return this.searchName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNow() {
		return this.pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	// public void setCheckBox(List<String> checkBox){
	// this.checkBox=checkBox;
	// }
	// public List<String>getCheckBox(){
	// return checkBox;
	// }
	public void setCheckBox(String checkBox) {
		this.checkBox = checkBox;
	}

	public String getCheckBox() {
		return this.checkBox;
	}

	public File1 getFile1() {
		return file1;
	}

	public void setFile1(File1 file1) {
		this.file1 = file1;
	}

	public void viewFile() throws Exception {
		FileDao fileDao = new FileDaoImp();
		File1 tempFile = fileDao.getOneFile(file1.getFileId());

		// Date tempDate=(Date) tempFile.getModifiedDate();
		DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
		String reTime = format2.format(tempFile.getModifiedDate());
		String tempName = "E:\\upload\\" + reTime + tempFile.getFileName();
		try {
			Runtime.getRuntime().exec("cmd.exe /c start " + tempName);
			System.out.println(1111111);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return SUCCESS;
	}

	public String newFold() throws Exception {
		People people = new People();
		Map session = (Map) ActionContext.getContext().getSession();
		people = (People) session.get("user");
		System.out.println(getNewFolder());
		Map request = (Map) ActionContext.getContext().get("request");
		if (people.getDepartmentNo() == 1) {
			request.put("path", "财务");
		} else if (people.getDepartmentNo() == 2) {
			request.put("path", "教务");
		} else if (people.getDepartmentNo() == 3) {
			request.put("path", "党务");
		} else if (people.getDepartmentNo() == 4) {
			request.put("path", "资产");
		} else if (people.getDepartmentNo() == 5) {
			request.put("path", "工会");
		} else if (people.getDepartmentNo() == 6) {
			request.put("path", "学生");
		} else if (people.getDepartmentNo() == 7) {
			request.put("path", "教职工");
		} else if (people.getDepartmentNo() == 8) {
			request.put("path", "领导");
		}
		request.put("filePath", getNewFolder());
		return SUCCESS;
	}

	public String saveFold() throws Exception {

		People people = new People();
		Map session = (Map) ActionContext.getContext().getSession();
		people = (People) session.get("user");
		FileDao fileDao = new FileDaoImp();
		File1 temp = new File1();
		System.out.println(getNewFolder() + "\\\\\\\\|" + getNewFoldName());
		temp.setFileName(getNewFoldName());
		String name;
		if (people.getDepartmentNo() == 1) {
			name = "财务";
			temp.setFilePath(name);
		} else if (people.getDepartmentNo() == 2) {
			name = "教务";
			temp.setFilePath(name);
		} else if (people.getDepartmentNo() == 3) {
			name = "党务";
			temp.setFilePath(name);
		} else if (people.getDepartmentNo() == 4) {
			name = "资产";
			temp.setFilePath(name);
		} else if (people.getDepartmentNo() == 5) {
			name = "工会";
			temp.setFilePath(name);
		} else if (people.getDepartmentNo() == 6) {
			name = "学生";
			temp.setFilePath(name);
		} else if (people.getDepartmentNo() == 7) {
			name = "教职工";
			temp.setFilePath(name);
		} else if (people.getDepartmentNo() == 8) {
			name = "领导";
			temp.setFilePath(name);
		}
		temp.setModifiedDate(new Date(System.currentTimeMillis()));
		temp.setOwnPeopleId(people.getPeopleId());
		temp.setOwnDepartNo(people.getDepartmentNo());
		temp.setKind("文件夹");
		temp.setPeopleName(people.getPeopleName());
		fileDao.save(temp);
		FileauthorityDao fileauthorityDao = new FileauthorityDaoImp();
		FileauthorityId fileauthorityId = new FileauthorityId();
		Fileauthority fileauthority = new Fileauthority();
		if (people.getDepartmentNo() == 1) {
			fileauthorityId.setDepartmentNo(1);
			fileauthorityId.setFileId(temp.getFileId());
			fileauthority.setId(fileauthorityId);
			fileauthority.setIsFolder(1);
			fileauthority.setIsViewable(1);
			fileauthorityDao.save(fileauthority);
		}
		if (people.getDepartmentNo() == 2) {
			fileauthorityId.setDepartmentNo(2);
			fileauthorityId.setFileId(temp.getFileId());
			fileauthority.setId(fileauthorityId);
			fileauthority.setIsFolder(1);
			fileauthority.setIsViewable(1);
			fileauthorityDao.save(fileauthority);
		}
		if (people.getDepartmentNo() == 3) {
			fileauthorityId.setDepartmentNo(3);
			fileauthorityId.setFileId(temp.getFileId());
			fileauthority.setId(fileauthorityId);
			fileauthority.setIsFolder(1);
			fileauthority.setIsViewable(1);
			fileauthorityDao.save(fileauthority);
		}
		if (people.getDepartmentNo() == 4) {
			fileauthorityId.setDepartmentNo(4);
			fileauthorityId.setFileId(temp.getFileId());
			fileauthority.setId(fileauthorityId);
			fileauthority.setIsFolder(1);
			fileauthority.setIsViewable(1);
			fileauthorityDao.save(fileauthority);
		}
		if (people.getDepartmentNo() == 5) {
			fileauthorityId.setDepartmentNo(5);
			fileauthorityId.setFileId(temp.getFileId());
			fileauthority.setId(fileauthorityId);
			fileauthority.setIsFolder(1);
			fileauthority.setIsViewable(1);
			fileauthorityDao.save(fileauthority);
		}
		if (people.getDepartmentNo() == 6) {
			fileauthorityId.setDepartmentNo(6);
			fileauthorityId.setFileId(temp.getFileId());
			fileauthority.setId(fileauthorityId);
			fileauthority.setIsFolder(1);
			fileauthority.setIsViewable(1);
			fileauthorityDao.save(fileauthority);
		}
		if (people.getDepartmentNo() == 7) {
			fileauthorityId.setDepartmentNo(7);
			fileauthorityId.setFileId(temp.getFileId());
			fileauthority.setId(fileauthorityId);
			fileauthority.setIsFolder(1);
			fileauthority.setIsViewable(1);
			fileauthorityDao.save(fileauthority);
		}
		if (people.getDepartmentNo() == 8) {
			fileauthorityId.setDepartmentNo(8);
			fileauthorityId.setFileId(temp.getFileId());
			fileauthority.setId(fileauthorityId);
			fileauthority.setIsFolder(1);
			fileauthority.setIsViewable(1);
			fileauthorityDao.save(fileauthority);
		}

		return SUCCESS;
	}

	public String upload() throws Exception {
		FileDao fileDao = new FileDaoImp();
		People people = new People();
		Map session = (Map) ActionContext.getContext().getSession();
		people = (People) session.get("user");
		Date tempDate = new Date(System.currentTimeMillis());
		if (upload != null) {
			for (int i = 0; i < upload.size(); i++) { // 遍历，得到每个文件对他们进行读写操作
				DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
				String reTime = format2.format(tempDate);
				InputStream is = new FileInputStream(upload.get(i));
				OutputStream os = new FileOutputStream("e:\\upload\\" + reTime
						+ getUploadFileName().get(i));
				byte buffer[] = new byte[1024];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					os.write(buffer, 0, count);
				}
				os.close();
				is.close();
				double size = upload.get(i).length();
				String danwei;
				if (size > 1024 * 1024) {
					size /= (1024 * 1024);
					BigDecimal b = new BigDecimal(size);
					double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue();
					danwei = f1 + "MB";
				} else {
					size /= 1024;
					BigDecimal b = new BigDecimal(size);
					double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue();
					danwei = f1 + "KB";
				}
				file1.setFileName(getUploadFileName().get(i));
				Map request = (Map) ActionContext.getContext().get("request");
				String hehe = getUploadFileName().get(i);
				request.put("showFileName", hehe);
				if (getTempId() == 0) {
					if (people.getDepartmentNo() == 1) {
						file1.setFilePath("财务");
					} else if (people.getDepartmentNo() == 2) {
						file1.setFilePath("教务");
					} else if (people.getDepartmentNo() == 3) {
						file1.setFilePath("党务");
					} else if (people.getDepartmentNo() == 4) {
						file1.setFilePath("资产");
					} else if (people.getDepartmentNo() == 5) {
						file1.setFilePath("工会");
					} else if (people.getDepartmentNo() == 6) {
						file1.setFilePath("学生");
					} else if (people.getDepartmentNo() == 7) {
						file1.setFilePath("教职工");
					} else if (people.getDepartmentNo() == 8) {
						file1.setFilePath("领导");
					}
					file1.setKind(file1.getKind());
					file1.setModifiedDate(tempDate);
					file1.setOwnPeopleId(people.getPeopleId());
					file1.setSize(danwei);
					file1.setOwnDepartNo(people.getDepartmentNo());
					file1.setPeopleName(people.getPeopleName());
				} else {
					File1 temp = new File1();
					temp = fileDao.getOneFile(getTempId());
					file1.setFilePath(temp.getFilePath() + "\\"
							+ temp.getFileName());
					file1.setKind(file1.getKind());
					file1.setModifiedDate(tempDate);
					file1.setOwnPeopleId(people.getPeopleId());
					file1.setSize(danwei);
					file1.setOwnDepartNo(people.getDepartmentNo());
					file1.setPeopleName(people.getPeopleName());
				}
				fileDao.save(file1);
				File1 file2 = fileDao.getOneFile(file1.getFileName());
				System.out.println(file2.getFileName()
						+ file2.getModifiedDate());
				FileauthorityDao fileauthorityDao = new FileauthorityDaoImp();
				Fileauthority fileauthority = new Fileauthority();
				FileauthorityId fileauthorityId = new FileauthorityId();
				// System.out.println("checkBox的大小为：
				// "+checkBox.size()+"|||||"+checkBox.get(0)+"|||"+checkBox.get(1)+"|||||"+checkBox.get(2));
				// fileauthority.setDepartmentNo(departmentNo);
				// fileauthority.setFileId(fileId);
				// fileauthority.setIsFolder(isFolder);
				// fileauthority.setIsViewable(isViewable);
				// fileauthorityDao.save(fileauthority);
				// String[] checkBoxs = request.getParameterValues("checkbox");
				// document.getElementById("Checkbox1");

				if (getCheckBox() == null) {
					System.out.println("1111111111");
					DepartmentDao departDao = new DepartmentDaoImp();
					Department depart = departDao.getDepartment(people
							.getDepartmentNo());
					if (depart.getDepartmentName().equals("财务部门")) {
						fileauthorityId.setDepartmentNo(1);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(1);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}
					if (depart.getDepartmentName().equals("教务部门")) {
						fileauthorityId.setDepartmentNo(2);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(2);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}
					if (depart.getDepartmentName().equals("党务部门")) {
						fileauthorityId.setDepartmentNo(3);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(3);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}
					if (depart.getDepartmentName().equals("资产部门")) {
						fileauthorityId.setDepartmentNo(4);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(4);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}
					if (depart.getDepartmentName().equals("工会部门")) {
						fileauthorityId.setDepartmentNo(5);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(5);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}
					if (depart.getDepartmentName().equals("学生部门")) {
						fileauthorityId.setDepartmentNo(6);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(6);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}
					if (depart.getDepartmentName().equals("教职工部门")) {
						fileauthorityId.setDepartmentNo(7);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(7);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}

				} else {

					String[] chkValues = this.getCheckBox().split(", ");
					// System.out.println(chkValues[0] + "|||" + chkValues[1] +
					// "|||"
					// + chkValues[2]);
					Set<String> department = new HashSet<String>();
					for (int j = 0; j < chkValues.length; j++) {
						department.add(chkValues[j]);
					}
					DepartmentDao departDao = new DepartmentDaoImp();
					Department depart = departDao.getDepartment(people
							.getDepartmentNo());
					if (department.contains("财务部门")
							|| depart.getDepartmentName().equals("财务部门")) {
						fileauthorityId.setDepartmentNo(1);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(1);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}
					if (department.contains("教务部门")
							|| depart.getDepartmentName().equals("教务部门")) {
						fileauthorityId.setDepartmentNo(2);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(2);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}
					if (department.contains("党务部门")
							|| depart.getDepartmentName().equals("党务部门")) {
						fileauthorityId.setDepartmentNo(3);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(3);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}
					if (department.contains("资产部门")
							|| depart.getDepartmentName().equals("资产部门")) {
						fileauthorityId.setDepartmentNo(4);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(4);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}
					if (department.contains("工会部门")
							|| depart.getDepartmentName().equals("工会部门")) {
						fileauthorityId.setDepartmentNo(5);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(5);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}
					if (department.contains("学生部门")
							|| depart.getDepartmentName().equals("学生部门")) {
						fileauthorityId.setDepartmentNo(6);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(6);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}
					if (department.contains("教职工部门")
							|| depart.getDepartmentName().equals("教职工部门")) {
						fileauthorityId.setDepartmentNo(7);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(1);
						fileauthorityDao.save(fileauthority);
					} else {
						fileauthorityId.setDepartmentNo(7);
						fileauthorityId.setFileId(file2.getFileId());
						fileauthority.setId(fileauthorityId);
						fileauthority.setIsFolder(0);
						fileauthority.setIsViewable(0);
						fileauthorityDao.save(fileauthority);
					}

				}
			}
		}
		setCheckBox(null);
		myFile();
		// setMessage("文件上传完成");

		return SUCCESS;
	}

	// 新增
	public String changeFolder() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		FileDao fileDao = new FileDaoImp();
		File1 tempFile = fileDao.getOneFile(file1.getFileId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("tempFile", tempFile);
		request.put("newFoldName", getNewFoldName());
		return SUCCESS;
	}

	// 新增
	public String updateFolder() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		FileDao fileDao = new FileDaoImp();
		File1 tempFile = fileDao.getOneFile(file1.getFileId());
		String name = tempFile.getFileName();
		tempFile.setFileName(file1.getFileName());
		fileDao.save(tempFile);
		String tempPath = "";
		if (people.getDepartmentNo() == 1) {
			tempPath = "财务";
		} else if (people.getDepartmentNo() == 2) {
			tempPath = "教务";
		} else if (people.getDepartmentNo() == 3) {
			tempPath = "党务";
		} else if (people.getDepartmentNo() == 4) {
			tempPath = "资产";
		} else if (people.getDepartmentNo() == 5) {
			tempPath = "工会";
		} else if (people.getDepartmentNo() == 6) {
			tempPath = "学生";
		} else if (people.getDepartmentNo() == 7) {
			tempPath = "教职工";
		} else if (people.getDepartmentNo() == 8) {
			tempPath = "领导";
		}
		List<File1> fileList = (List<File1>) fileDao.getFileByPath(tempPath
				+ "\\" + name, people.getPeopleId());
		for (int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setFilePath(tempPath + "\\" + file1.getFileName());
			fileDao.save(fileList.get(i));
		}
		myFile();
		return SUCCESS;
	}

	// 修改 22号
	public String myFile() throws Exception {
		// Map session = (Map) ActionContext.getContext().getSession();
		// People people = (People) session.get("user");
		// FileDao fileDao = new FileDaoImp();
		// List<File1> fileList = fileDao.getAll(people.getPeopleId(), pageNow,
		// pageSize);
		// Map request = (Map) ActionContext.getContext().get("request");
		// Pager page = new Pager(getPageNow(), fileDao.findSize(people
		// .getPeopleId()));
		// // 保存
		// request.put("fileList", fileList);
		// request.put("page", page);
		// return SUCCESS;
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		FileDao fileDao = new FileDaoImp();
		List<File1> fileFolder = fileDao.getAll(people.getPeopleId(), pageNow,
				pageSize);
		PeopleDao peopleDao=new PeopleDaoImp();		
		Map request = (Map) ActionContext.getContext().get("request");
		String tempPath = "";
		if (people.getDepartmentNo() == 1) {
			tempPath = "财务";
		} else if (people.getDepartmentNo() == 2) {
			tempPath = "教务";
		} else if (people.getDepartmentNo() == 3) {
			tempPath = "党务";
		} else if (people.getDepartmentNo() == 4) {
			tempPath = "资产";
		} else if (people.getDepartmentNo() == 5) {
			tempPath = "工会";
		} else if (people.getDepartmentNo() == 6) {
			tempPath = "学生";
		} else if (people.getDepartmentNo() == 7) {
			tempPath = "教职工";
		} else if (people.getDepartmentNo() == 8) {
			tempPath = "领导";
		}
		List<File1> fileList = fileDao.getMyFile(people.getPeopleId(),
				tempPath, pageNow, pageSize);

		Pager page = new Pager(getPageNow(), fileFolder.size()
				+ fileList.size());
		// 保存
		request.put("fileList", fileList);
		request.put("fileFolder", fileFolder);
		request.put("page", page);
		return SUCCESS;

	}

	// 新增
	public String deleteFolder() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		FileDao fileDao = new FileDaoImp();
		File1 tempFile = fileDao.getOneFile(file1.getFileId());
		String name = tempFile.getFileName();
		fileDao.delete(tempFile.getFileId());
		String tempPath = "";
		if (people.getDepartmentNo() == 1) {
			tempPath = "财务";
		} else if (people.getDepartmentNo() == 2) {
			tempPath = "教务";
		} else if (people.getDepartmentNo() == 3) {
			tempPath = "党务";
		} else if (people.getDepartmentNo() == 4) {
			tempPath = "资产";
		} else if (people.getDepartmentNo() == 5) {
			tempPath = "工会";
		} else if (people.getDepartmentNo() == 6) {
			tempPath = "学生";
		} else if (people.getDepartmentNo() == 7) {
			tempPath = "教职工";
		} else if (people.getDepartmentNo() == 8) {
			tempPath = "领导";
		}
		fileDao.deleteFolder(tempPath + "\\" + name, people.getPeopleId());
		FileauthorityDao fileauthorityDao = new FileauthorityDaoImp();
		fileauthorityDao.delete(tempFile.getFileId());
		myFile();
		return SUCCESS;
	}

	public String delete() throws Exception {
		// Map session=(Map)ActionContext.getContext().getSession();
		FileDao fileDao = new FileDaoImp();
		FileauthorityDao authority = new FileauthorityDaoImp();
		File1 file = fileDao.getOneFile(file1.getFileId());
		DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
		String reTime = format2.format(file.getModifiedDate());
		String a = reTime + file.getFileName();
		File f = new File("E:\\upload\\" + a); // 输入要删除的文件位置
		if (f.exists()) {
			f.delete();
			fileDao.delete(file1.getFileId());
			authority.delete(file1.getFileId());
		}
		myFile();
		return SUCCESS;
	}

	// 修改 22号
	public String changeInfo() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();
		FileauthorityDao fileauthorityDao = new FileauthorityDaoImp();
		List<Fileauthority> fileauthority = fileauthorityDao.getFileList(file1
				.getFileId());
		FileDao fileDao = new FileDaoImp();
		File1 file = fileDao.getOneFile(file1.getFileId());
		Map request = (Map) ActionContext.getContext().get("request");
		// 保存

		String tempName = file.getFileName();
		int index = tempName.lastIndexOf(".");
		String houzhui = tempName.substring(index);
		String qianzhui = tempName.substring(0, index);
		List<Fileauthority> authority = fileauthorityDao.getFileList(file1
				.getFileId());
		session.put("houzhui", houzhui);
		String caiwu = "";
		String jiaowu = "";
		String dangwu = "";
		String zichan = "";
		String gonghui = "";
		String xuesheng = "";
		String jiaozhigong = "";
		for (int i = 0; i < authority.size(); i++) {
			if (authority.get(i).getId().getDepartmentNo() == 1
					&& authority.get(i).getIsViewable() == 1) {
				caiwu = "财务";
				continue;
			}
			if (authority.get(i).getId().getDepartmentNo() == 2
					&& authority.get(i).getIsViewable() == 1) {
				jiaowu = "教务";
				continue;
			}
			if (authority.get(i).getId().getDepartmentNo() == 3
					&& authority.get(i).getIsViewable() == 1) {
				dangwu = "党务";
				continue;
			}
			if (authority.get(i).getId().getDepartmentNo() == 4
					&& authority.get(i).getIsViewable() == 1) {
				zichan = "资产";
				continue;
			}
			if (authority.get(i).getId().getDepartmentNo() == 5
					&& authority.get(i).getIsViewable() == 1) {
				gonghui = "工会";
				continue;
			}
			if (authority.get(i).getId().getDepartmentNo() == 6
					&& authority.get(i).getIsViewable() == 1) {
				xuesheng = "学生";
				continue;
			}
			if (authority.get(i).getId().getDepartmentNo() == 7
					&& authority.get(i).getIsViewable() == 1) {
				jiaozhigong = "教职工";
				continue;
			}
		}
		request.put("caiwu", caiwu);
		request.put("jiaowu", jiaowu);
		request.put("dangwu", dangwu);
		request.put("zichan", zichan);
		request.put("gonghui", gonghui);
		request.put("xuesheng", xuesheng);
		request.put("jiaozhigong", jiaozhigong);
		request.put("houzhui", houzhui);
		request.put("qianzhui", qianzhui);
		request.put("fileInfo", file);
		return SUCCESS;
	}

	public String updateFile() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		DepartmentDao departDao = new DepartmentDaoImp();
		Department depart = departDao.getDepartment(people.getDepartmentNo());
		FileauthorityDao fileauthorityDao = new FileauthorityDaoImp();
		Fileauthority fileauthority = new Fileauthority();
		FileauthorityId fileauthorityId = new FileauthorityId();
		FileDao fileDao = new FileDaoImp();
		File1 temp = fileDao.getOneFile(file1.getFileId());
		DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
		String rTime = format2.format(temp.getModifiedDate());
		File f = new File("e:/upload/" + rTime + temp.getFileName());
		String houzhui = (String) session.get("houzhui");
		temp.setFileName(file1.getFileName() + houzhui);
		Date date = new Date(System.currentTimeMillis());
		temp.setModifiedDate(date);
		fileDao.save(temp);

		String reTime = format2.format(date);

		String c = f.getParent();
		File mm = new File(c + File.separator + reTime + temp.getFileName());
		if (f.renameTo(mm)) {
			System.out.println("修改成功!");
		} else {
			System.out.println("修改失败");
		}
		if (getCheckBox() == null) {
			if (depart.getDepartmentName().equals("财务部门")) {
				fileauthorityId.setDepartmentNo(1);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(1);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
			if (depart.getDepartmentName().equals("教务部门")) {
				fileauthorityId.setDepartmentNo(2);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(2);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
			if (depart.getDepartmentName().equals("党务部门")) {
				fileauthorityId.setDepartmentNo(3);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(3);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
			if (depart.getDepartmentName().equals("资产部门")) {
				fileauthorityId.setDepartmentNo(4);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(4);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
			if (depart.getDepartmentName().equals("工会部门")) {
				fileauthorityId.setDepartmentNo(5);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(5);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
			if (depart.getDepartmentName().equals("学生部门")) {
				fileauthorityId.setDepartmentNo(6);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(6);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
			if (depart.getDepartmentName().equals("教职工部门")) {
				fileauthorityId.setDepartmentNo(7);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(7);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}

		} else {
			String[] chkValues = this.getCheckBox().split(", ");
			// System.out.println(chkValues[0] + "|||" + chkValues[1] + "|||"
			// + chkValues[2]);

			Set<String> department = new HashSet<String>();
			for (int j = 0; j < chkValues.length; j++) {
				department.add(chkValues[j]);
			}
			if (department.contains("财务部门")
					|| depart.getDepartmentName().equals("财务部门")) {
				fileauthorityId.setDepartmentNo(1);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(1);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
			if (department.contains("教务部门")
					|| depart.getDepartmentName().equals("教务部门")) {
				fileauthorityId.setDepartmentNo(2);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(2);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
			if (department.contains("党务部门")
					|| depart.getDepartmentName().equals("党务部门")) {
				fileauthorityId.setDepartmentNo(3);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(3);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
			if (department.contains("资产部门")
					|| depart.getDepartmentName().equals("资产部门")) {
				fileauthorityId.setDepartmentNo(4);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(4);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
			if (department.contains("工会部门")
					|| depart.getDepartmentName().equals("工会部门")) {
				fileauthorityId.setDepartmentNo(5);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(5);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
			if (department.contains("学生部门")
					|| depart.getDepartmentName().equals("学生部门")) {
				fileauthorityId.setDepartmentNo(6);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(6);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
			if (department.contains("教职工部门")
					|| depart.getDepartmentName().equals("教职工部门")) {
				fileauthorityId.setDepartmentNo(7);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(1);
				fileauthorityDao.save(fileauthority);
			} else {
				fileauthorityId.setDepartmentNo(7);
				fileauthorityId.setFileId(file1.getFileId());
				fileauthority.setId(fileauthorityId);
				fileauthority.setIsFolder(0);
				fileauthority.setIsViewable(0);
				fileauthorityDao.save(fileauthority);
			}
		}
		myFile();
		return SUCCESS;
	}

	// 修改 22号
	public String upload1() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		if (people.getDepartmentNo() == 1) {
			request.put("path", "财务");
		} else if (people.getDepartmentNo() == 2) {
			request.put("path", "教务");
		} else if (people.getDepartmentNo() == 3) {
			request.put("path", "党务");
		} else if (people.getDepartmentNo() == 4) {
			request.put("path", "资产");
		} else if (people.getDepartmentNo() == 5) {
			request.put("path", "工会");
		} else if (people.getDepartmentNo() == 6) {
			request.put("path", "学生");
		} else if (people.getDepartmentNo() == 7) {
			request.put("path", "教职工");
		} else if (people.getDepartmentNo() == 8) {
			request.put("path", "领导");
		}
		return SUCCESS;
	}

	// 修改
	public String upload2() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		FileDao fileDao = new FileDaoImp();
		File1 temp = fileDao.getOneFile(file1.getFileId());
		request.put("path", temp.getFilePath() + "\\" + temp.getFileName());
		request.put("fileId", file1.getFileId());
		return SUCCESS;
	}

	public String allFile() throws Exception {
		FileDao fileDao = new FileDaoImp();
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		Map request = (Map) ActionContext.getContext().get("request");
		List<File1> allFile;
		Pager page;
		if (people.getGroupNo() == 2 || people.getGroupNo() == 0) {
			allFile = fileDao.getAbsoluteAll(pageNow, pageSize);

			page = new Pager(getPageNow(), fileDao.findSize());
		} else {
			allFile = fileDao.getALLByDepartNo(people.getDepartmentNo());
			// Map request=(Map)ActionContext.getContext().get("request");
			page = new Pager(getPageNow(), fileDao.findSize());
		}
		// 保存
		request.put("allFile", allFile);
		request.put("page", page);
		return SUCCESS;
	}

	// 修改 22号
	public String enterFold() throws Exception {
		FileDao fileDao = new FileDaoImp();
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");

		List<File1> allFile;
		Pager page;
		file1 = fileDao.getOneFile(file1.getFileId());
		if (people.getGroupNo() == 2 || people.getGroupNo() == 0) {
			allFile = fileDao.getFileForLeader(file1.getOwnDepartNo(), file1
					.getFilePath()
					+ "\\" + file1.getFileName(), pageNow, pageSize);
			page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		} else {
			allFile = fileDao.getAllFromDepartNo(people.getDepartmentNo(),
					file1.getFilePath() + "\\" + file1.getFileName());
			FileauthorityDao authorityDao = new FileauthorityDaoImp();
			Fileauthority fileauthority = new Fileauthority();
			for (int i = 0; i < allFile.size(); i++) {
				if (authorityDao.getAuthority(allFile.get(i).getFileId(),
						people.getDepartmentNo()).getIsViewable() == 0) {
					allFile.remove(i);
				}
			}
			page = new Pager(getPageNow(), allFile.size());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		// 保存
		request.put("allFile", allFile);
		request.put("page", page);
		request.put("fileId", file1.getFileId());
		request.put("people", people);
		// request.put("allFolder", allFolder);
		// request.put("caiwuDept", "caiwu");

		return SUCCESS;
	}

	public String enterFold1() throws Exception {
		FileDao fileDao = new FileDaoImp();
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");

		List<File1> allFile;
		Pager page;
		file1 = fileDao.getOneFile(file1.getFileId());
		if (people.getGroupNo() == 2 || people.getGroupNo() == 0) {
			allFile = fileDao.getFileForLeader(file1.getOwnDepartNo(), file1
					.getFilePath()
					+ "\\" + file1.getFileName(), pageNow, pageSize);
			page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		} else {
			allFile = fileDao.getAllFromDepartNo(people.getDepartmentNo(),
					file1.getFilePath() + "\\" + file1.getFileName());
			FileauthorityDao authorityDao = new FileauthorityDaoImp();
			Fileauthority fileauthority = new Fileauthority();
			for (int i = 0; i < allFile.size(); i++) {
				if (authorityDao.getAuthority(allFile.get(i).getFileId(),
						people.getDepartmentNo()).getIsViewable() == 0) {
					allFile.remove(i);
				}
			}
			page = new Pager(getPageNow(), allFile.size());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		// 保存
		request.put("allFile", allFile);
		request.put("page", page);
		request.put("fileId", file1.getFileId());
		request.put("people", people);
		// request.put("allFolder", allFolder);
		// request.put("caiwuDept", "caiwu");

		return SUCCESS;
	}

	// 新增 22号
	public String leader() throws Exception {
		FileDao fileDao = new FileDaoImp();
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		List<File1> allFolder;
		allFolder = fileDao.getAllFolder(8);
		List<File1> leaderFile;
		Pager page;
		if (people.getGroupNo() == 2 || people.getGroupNo() == 0) {
			leaderFile = fileDao.getFileForLeader(8, "领导", pageNow, pageSize);
			page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		} else {
			leaderFile = fileDao.getAllFromDepartNo(people.getPeopleId(), "领导");
			FileauthorityDao authorityDao = new FileauthorityDaoImp();
			Fileauthority fileauthority = new Fileauthority();
			for (int i = 0; i < leaderFile.size(); i++) {
				if (authorityDao.getAuthority(leaderFile.get(i).getFileId(),
						people.getDepartmentNo()).getIsViewable() == 0) {
					leaderFile.remove(i);
					i--;
				}
			}
			page = new Pager(getPageNow(), leaderFile.size() + allFolder.size());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		// 保存
		request.put("leaderFile", leaderFile);
		request.put("page", page);
		request.put("allFolder", allFolder);
		request.put("caiwuDept", "caiwu");
		String hehe = (String) request.get("caiwuDept");
		request.put("people", people);
		System.out.println(hehe);
		return SUCCESS;
	}

	public String caiwu() throws Exception {
		FileDao fileDao = new FileDaoImp();
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		List<File1> allFolder;
		allFolder = fileDao.getAllFolder(1);
		List<File1> caiwuFile;
		Pager page;
		if (people.getGroupNo() == 2 || people.getGroupNo() == 0) {
			caiwuFile = fileDao.getFileForLeader(1, "财务", pageNow, pageSize);
			page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		} else {
			caiwuFile = fileDao.getAllFromDepartNo(people.getPeopleId(), "财务");
			FileauthorityDao authorityDao = new FileauthorityDaoImp();
			Fileauthority fileauthority = new Fileauthority();
			for (int i = 0; i < caiwuFile.size(); i++) {
				if (authorityDao.getAuthority(caiwuFile.get(i).getFileId(),
						people.getDepartmentNo()).getIsViewable() == 0) {
					caiwuFile.remove(i);
					i--;
				}
			}
			page = new Pager(getPageNow(), caiwuFile.size() + allFolder.size());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		// 保存
		request.put("caiwuFile", caiwuFile);
		request.put("page", page);
		request.put("allFolder", allFolder);
		request.put("caiwuDept", "caiwu");
		String hehe = (String) request.get("caiwuDept");
		request.put("people", people);
		System.out.println(hehe);
		return SUCCESS;
	}

	public String dangwu() throws Exception {
		// FileDao fileDao = new FileDaoImp();
		// Map session = (Map) ActionContext.getContext().getSession();
		// People people = (People) session.get("user");
		// List<File1> dangwuFile;
		// Pager page;
		// if (people.getGroupNo() == 0) {
		// dangwuFile = fileDao.getFileForLeader(3, pageNow, pageSize);
		// page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		// } else {
		// dangwuFile = fileDao.getAllFromDepartNo(3);
		// FileauthorityDao authorityDao = new FileauthorityDaoImp();
		// Fileauthority fileauthority = new Fileauthority();
		// for (int i = 0; i < dangwuFile.size(); i++) {
		// if (authorityDao.getAuthority(dangwuFile.get(i).getFileId(),
		// people.getDepartmentNo()).getIsViewable() == 0) {
		// dangwuFile.remove(i);
		// }
		// }
		// page = new Pager(getPageNow(), dangwuFile.size());
		// }
		// Map request = (Map) ActionContext.getContext().get("request");
		// // 保存
		// request.put("dangwuFile", dangwuFile);
		// request.put("page", page);
		// return SUCCESS;
		FileDao fileDao = new FileDaoImp();
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		List<File1> allFolder;
		allFolder = fileDao.getAllFolder(3);
		List<File1> dangwuFile;
		Pager page;
		if (people.getGroupNo() == 2 || people.getGroupNo() == 0) {
			dangwuFile = fileDao.getFileForLeader(3, "党务", pageNow, pageSize);
			page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		} else {
			dangwuFile = fileDao.getAllFromDepartNo(people.getPeopleId(), "党务");
			FileauthorityDao authorityDao = new FileauthorityDaoImp();
			Fileauthority fileauthority = new Fileauthority();
			for (int i = 0; i < dangwuFile.size(); i++) {
				if (authorityDao.getAuthority(dangwuFile.get(i).getFileId(),
						people.getDepartmentNo()).getIsViewable() == 0) {
					dangwuFile.remove(i);
					i--;
				}
			}
			page = new Pager(getPageNow(), dangwuFile.size() + allFolder.size());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		// 保存
		request.put("dangwuFile", dangwuFile);
		request.put("page", page);
		request.put("allFolder", allFolder);
		request.put("caiwuDept", "caiwu");
		String hehe = (String) request.get("caiwuDept");
		request.put("people", people);
		System.out.println(hehe);
		return SUCCESS;
	}

	public String zichan() throws Exception {
		// FileDao fileDao = new FileDaoImp();
		// Map session = (Map) ActionContext.getContext().getSession();
		// People people = (People) session.get("user");
		// List<File1> zichanFile;
		// Pager page;
		// if (people.getGroupNo() == 0) {
		// zichanFile = fileDao.getFileForLeader(4, pageNow, pageSize);
		// page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		// } else {
		// zichanFile = fileDao.getAllFromDepartNo(4);
		// FileauthorityDao authorityDao = new FileauthorityDaoImp();
		// Fileauthority fileauthority = new Fileauthority();
		// for (int i = 0; i < zichanFile.size(); i++) {
		// if (authorityDao.getAuthority(zichanFile.get(i).getFileId(),
		// people.getDepartmentNo()).getIsViewable() == 0) {
		// zichanFile.remove(i);
		// }
		// }
		// page = new Pager(getPageNow(), zichanFile.size());
		// }
		// Map request = (Map) ActionContext.getContext().get("request");
		// // 保存
		// request.put("zichanFile", zichanFile);
		// request.put("page", page);
		// return SUCCESS;
		FileDao fileDao = new FileDaoImp();
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		List<File1> allFolder;
		allFolder = fileDao.getAllFolder(4);
		List<File1> zichanFile;
		Pager page;
		if (people.getGroupNo() == 2 || people.getGroupNo() == 0) {
			zichanFile = fileDao.getFileForLeader(4, "资产", pageNow, pageSize);
			page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		} else {
			zichanFile = fileDao.getAllFromDepartNo(people.getPeopleId(), "资产");
			FileauthorityDao authorityDao = new FileauthorityDaoImp();
			Fileauthority fileauthority = new Fileauthority();
			for (int i = 0; i < zichanFile.size(); i++) {
				if (authorityDao.getAuthority(zichanFile.get(i).getFileId(),
						people.getDepartmentNo()).getIsViewable() == 0) {
					zichanFile.remove(i);
					i--;
				}
			}
			page = new Pager(getPageNow(), zichanFile.size() + allFolder.size());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		// 保存
		request.put("zichanFile", zichanFile);
		request.put("page", page);
		request.put("allFolder", allFolder);
		request.put("caiwuDept", "caiwu");
		String hehe = (String) request.get("caiwuDept");
		request.put("people", people);
		System.out.println(hehe);
		return SUCCESS;
	}

	public String gonghui() throws Exception {
		// FileDao fileDao = new FileDaoImp();
		// Map session = (Map) ActionContext.getContext().getSession();
		// People people = (People) session.get("user");
		// List<File1> gonghuiFile;
		// Pager page;
		// if (people.getGroupNo() == 0) {
		// gonghuiFile = fileDao.getFileForLeader(5, pageNow, pageSize);
		// page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		// } else {
		// gonghuiFile = fileDao.getAllFromDepartNo(5);
		// FileauthorityDao authorityDao = new FileauthorityDaoImp();
		// Fileauthority fileauthority = new Fileauthority();
		// for (int i = 0; i < gonghuiFile.size(); i++) {
		// if (authorityDao.getAuthority(gonghuiFile.get(i).getFileId(),
		// people.getDepartmentNo()).getIsViewable() == 0) {
		// gonghuiFile.remove(i);
		// }
		// }
		// page = new Pager(getPageNow(), gonghuiFile.size());
		// }
		// Map request = (Map) ActionContext.getContext().get("request");
		// // 保存
		// request.put("gonghuiFile", gonghuiFile);
		// request.put("page", page);
		// return SUCCESS;
		FileDao fileDao = new FileDaoImp();
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		List<File1> allFolder;
		allFolder = fileDao.getAllFolder(5);
		List<File1> gonghuiFile;
		Pager page;
		if (people.getGroupNo() == 2 || people.getGroupNo() == 0) {
			gonghuiFile = fileDao.getFileForLeader(5, "工会", pageNow, pageSize);
			page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		} else {
			gonghuiFile = fileDao
					.getAllFromDepartNo(people.getPeopleId(), "工会");
			FileauthorityDao authorityDao = new FileauthorityDaoImp();
			Fileauthority fileauthority = new Fileauthority();
			for (int i = 0; i < gonghuiFile.size(); i++) {
				if (authorityDao.getAuthority(gonghuiFile.get(i).getFileId(),
						people.getDepartmentNo()).getIsViewable() == 0) {
					gonghuiFile.remove(i);
					i--;
				}
			}
			page = new Pager(getPageNow(), gonghuiFile.size()
					+ allFolder.size());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		// 保存
		request.put("gonghuiFile", gonghuiFile);
		request.put("page", page);
		request.put("allFolder", allFolder);
		request.put("caiwuDept", "caiwu");
		String hehe = (String) request.get("caiwuDept");
		request.put("people", people);
		System.out.println(hehe);
		return SUCCESS;
	}

	public String xuesheng() throws Exception {
		// FileDao fileDao = new FileDaoImp();
		// Map session = (Map) ActionContext.getContext().getSession();
		// People people = (People) session.get("user");
		// List<File1> xueshengFile;
		// Pager page;
		// if (people.getGroupNo() == 0) {
		// xueshengFile = fileDao.getFileForLeader(6, pageNow, pageSize);
		// page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		// } else {
		// xueshengFile = fileDao.getAllFromDepartNo(6);
		// FileauthorityDao authorityDao = new FileauthorityDaoImp();
		// Fileauthority fileauthority = new Fileauthority();
		// for (int i = 0; i < xueshengFile.size(); i++) {
		// if (authorityDao.getAuthority(xueshengFile.get(i).getFileId(),
		// people.getDepartmentNo()).getIsViewable() == 0) {
		// xueshengFile.remove(i);
		// }
		// }
		// page = new Pager(getPageNow(), xueshengFile.size());
		// }
		// Map request = (Map) ActionContext.getContext().get("request");
		// // 保存
		// request.put("xueshengFile", xueshengFile);
		// request.put("page", page);
		// return SUCCESS;
		FileDao fileDao = new FileDaoImp();
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		List<File1> allFolder;
		allFolder = fileDao.getAllFolder(6);
		List<File1> xueshengFile;
		Pager page;
		if (people.getGroupNo() == 2 || people.getGroupNo() == 0) {
			xueshengFile = fileDao.getFileForLeader(6, "学生", pageNow, pageSize);
			page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		} else {
			xueshengFile = fileDao.getAllFromDepartNo(people.getPeopleId(),
					"学生");
			FileauthorityDao authorityDao = new FileauthorityDaoImp();
			Fileauthority fileauthority = new Fileauthority();
			for (int i = 0; i < xueshengFile.size(); i++) {
				if (authorityDao.getAuthority(xueshengFile.get(i).getFileId(),
						people.getDepartmentNo()).getIsViewable() == 0) {
					xueshengFile.remove(i);
					i--;
				}
			}
			page = new Pager(getPageNow(), xueshengFile.size()
					+ allFolder.size());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		// 保存
		request.put("xueshengFile", xueshengFile);
		request.put("page", page);
		request.put("allFolder", allFolder);
		request.put("caiwuDept", "caiwu");
		String hehe = (String) request.get("caiwuDept");
		request.put("people", people);
		System.out.println(hehe);
		return SUCCESS;
	}

	public String jiaozhigong() throws Exception {
		// FileDao fileDao = new FileDaoImp();
		// Map session = (Map) ActionContext.getContext().getSession();
		// People people = (People) session.get("user");
		// List<File1> jiaozhigongFile;
		// Pager page;
		// if (people.getGroupNo() == 0) {
		// jiaozhigongFile = fileDao.getFileForLeader(7, pageNow, pageSize);
		// page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		// } else {
		// jiaozhigongFile = fileDao.getAllFromDepartNo(7);
		// FileauthorityDao authorityDao = new FileauthorityDaoImp();
		// Fileauthority fileauthority = new Fileauthority();
		// for (int i = 0; i < jiaozhigongFile.size(); i++) {
		// if (authorityDao.getAuthority(
		// jiaozhigongFile.get(i).getFileId(),
		// people.getDepartmentNo()).getIsViewable() == 0) {
		// jiaozhigongFile.remove(i);
		// }
		// }
		// page = new Pager(getPageNow(), jiaozhigongFile.size());
		// }
		// Map request = (Map) ActionContext.getContext().get("request");
		// // 保存
		// request.put("jiaozhigongFile", jiaozhigongFile);
		// request.put("page", page);
		// return SUCCESS;
		FileDao fileDao = new FileDaoImp();
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		List<File1> allFolder;
		allFolder = fileDao.getAllFolder(7);
		List<File1> jiaozhigongFile;
		Pager page;
		if (people.getGroupNo() == 2 || people.getGroupNo() == 0) {
			jiaozhigongFile = fileDao.getFileForLeader(7, "教职工", pageNow,
					pageSize);
			page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		} else {
			jiaozhigongFile = fileDao.getAllFromDepartNo(people.getPeopleId(),
					"教职工");
			FileauthorityDao authorityDao = new FileauthorityDaoImp();
			Fileauthority fileauthority = new Fileauthority();
			for (int i = 0; i < jiaozhigongFile.size(); i++) {
				if (authorityDao.getAuthority(
						jiaozhigongFile.get(i).getFileId(),
						people.getDepartmentNo()).getIsViewable() == 0) {
					jiaozhigongFile.remove(i);
					i--;
				}
			}
			page = new Pager(getPageNow(), jiaozhigongFile.size()
					+ allFolder.size());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		// 保存
		request.put("jiaozhigongFile", jiaozhigongFile);
		request.put("page", page);
		request.put("allFolder", allFolder);
		request.put("caiwuDept", "caiwu");
		String hehe = (String) request.get("caiwuDept");
		request.put("people", people);
		System.out.println(hehe);
		return SUCCESS;
	}

	public String download() throws Exception {
		FileDao fileDao = new FileDaoImp();
		File1 fileTemp = fileDao.getOneFile(file1.getFileId());

		DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
		String reTime = format2.format(fileTemp.getModifiedDate());
		GetFileName a = new GetFileName();
		setFilename(a.getDownloadChineseFileName(fileTemp.getFileName()));
		setFullName(a.fullFileName(fileTemp.getFileName(), reTime));
		return SUCCESS;
	}

	public String jiaowu() throws Exception {
		// FileDao fileDao = new FileDaoImp();
		// Map session = (Map) ActionContext.getContext().getSession();
		// People people = (People) session.get("user");
		// List<File1> jiaowuFile;
		// Pager page;
		// if (people.getGroupNo() == 0) {
		// jiaowuFile = fileDao.getFileForLeader(2, pageNow, pageSize);
		// page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		// } else {
		// jiaowuFile = fileDao.getAllFromDepartNo(2);
		// FileauthorityDao authorityDao = new FileauthorityDaoImp();
		// Fileauthority fileauthority = new Fileauthority();
		// for (int i = 0; i < jiaowuFile.size(); i++) {
		// if (authorityDao.getAuthority(jiaowuFile.get(i).getFileId(),
		// people.getDepartmentNo()).getIsViewable() == 0) {
		// jiaowuFile.remove(i);
		// }
		// }
		// page = new Pager(getPageNow(), jiaowuFile.size());
		// }
		// Map request = (Map) ActionContext.getContext().get("request");
		// // 保存
		// request.put("page", page);
		// request.put("jiaowuFile", jiaowuFile);
		// return SUCCESS;
		FileDao fileDao = new FileDaoImp();
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		List<File1> allFolder;
		allFolder = fileDao.getAllFolder(2);
		List<File1> jiaowuFile;
		Pager page;
		if (people.getGroupNo() == 2 || people.getGroupNo() == 0) {
			jiaowuFile = fileDao.getFileForLeader(2, "教务", pageNow, pageSize);
			page = new Pager(getPageNow(), fileDao.getSizeForLeader(1));
		} else {
			jiaowuFile = fileDao.getAllFromDepartNo(people.getPeopleId(), "教务");
			FileauthorityDao authorityDao = new FileauthorityDaoImp();
			Fileauthority fileauthority = new Fileauthority();
			for (int i = 0; i < jiaowuFile.size(); i++) {
				if (authorityDao.getAuthority(jiaowuFile.get(i).getFileId(),
						people.getDepartmentNo()).getIsViewable() == 0) {
					jiaowuFile.remove(i);
					i--;
				}
			}
			page = new Pager(getPageNow(), jiaowuFile.size() + allFolder.size());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		// 保存
		request.put("jiaowuFile", jiaowuFile);
		request.put("page", page);
		request.put("allFolder", allFolder);
		request.put("caiwuDept", "caiwu");
		String hehe = (String) request.get("caiwuDept");
		request.put("people", people);
		System.out.println(hehe);
		return SUCCESS;
	}

	public String search() throws Exception {
		FileDao fileDao = new FileDaoImp();
		List<File1> searchList;
		searchList = fileDao.getFileListByName(searchName);
		Map session = (Map) ActionContext.getContext().getSession();
		People people = (People) session.get("user");
		Pager page;
		if (people.getGroupNo() == 2) {

			page = new Pager(getPageNow(), searchList.size());
		} else {
			FileauthorityDao authorityDao = new FileauthorityDaoImp();
			Fileauthority fileauthority = new Fileauthority();
			for (int i = 0; i < searchList.size(); i++) {
				fileauthority = authorityDao.getAuthority(searchList.get(i)
						.getFileId(), people.getDepartmentNo());
				if (fileauthority != null) {
					if (fileauthority.getIsViewable() == 0) {
						searchList.remove(i);
						i--;
					}
				} else {
					searchList.remove(i);
					i--;
				}
			}
			page = new Pager(getPageNow(), searchList.size());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("searchList", searchList);
		request.put("page", page);
		return SUCCESS;
	}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public InputStream getTargetFile() throws Exception {
		// 要下载的文件
		File file = new File("E://upload//" + fullName);
		InputStream is = new FileInputStream(file);
		System.out.println(fullName);
		return is;
		// return
		// ServletActionContext.getServletContext().getResourceAsStream(this.inputPath+filename);
	}

	// public File getImage() {
	// return image;
	// }
	//
	// public void setImage(File image) {
	// this.image = image;
	// }

	// private void close(FileOutputStream fos, FileInputStream fis) {
	// if (fis != null) {
	// try {
	// fis.close();
	// } catch (IOException e) {
	// System.out.println("FileInputStream关闭失败");
	// e.printStackTrace();
	// }
	// }
	// if (fos != null) {
	// try {
	// fos.close();
	// } catch (IOException e) {
	// System.out.println("FileOutputStream关闭失败");
	// e.printStackTrace();
	// }
	// }
	// }

}
