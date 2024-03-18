// FIXME - package 패키지 경로를 적어주세요 

// FIXME - import 정보를 적어주세요 


@Service
@BxmCategory(logicalName="EmpService", description="EmpService")
public class EmpService {

	@Autowired
	private EmpDAO empDAO;

	@Autowired
	private EmpFileService empFileService;

	@BxmCategory(logicalName="FIXME-selectListEmp", description="FIXME-selectListEmp")
	public List<EmpVo> selectListEmp(EmpVo empVo) throws ElException
	{
//		TODO - 주석을 풀고 작성하세요.
//     List<EmpVo> list = empDAO.selectListEmp(empVo);
//     return list;
		throw new Exception("개발중 코드");
		return null;
	}

	@BxmCategory(logicalName="FIXME-selectListCountEmp", description="FIXME-selectListCountEmp")
	public long selectListCountEmp(EmpVo empVo) throws ElException
	{
//		TODO - 주석을 풀고 작성하세요.
//     return empDAO.selectListCountEmp(empVo);
		throw new Exception("개발중 코드");
		return null;
	}

	@BxmCategory(logicalName="FIXME-selectEmp", description="FIXME-selectEmp")
	public EmpVo selectEmp(EmpVo empVo) throws ElException
	{
//		TODO - 주석을 풀고 작성하세요.
//     EmpVo resultVO = empDAO.selectEmp(empVo);
//     //		if (resultVO == null) {
//     //			throw new UserException("EL.ERROR.COMM.001"); // 별도의 예외 메시지가 필요한 경우 처리 예시
//     //		}
//     return resultVO;
		throw new Exception("개발중 코드");
		return null;
	}

	@BxmCategory(logicalName="FIXME-insertEmp", description="FIXME-insertEmp")
	public int insertEmp(EmpVo empVo) throws ElException, IOException
	{
//		TODO - 주석을 풀고 작성하세요.
//     int iRet = empDAO.insertEmp(empVo);
//     if (empVo.getInputFileData() != null && empVo.getInputFileData().getSize() > 0) {
//         EmpVo retEmpVo = (EmpVo) empVo.clone();
//         retEmpVo = getEmpVo(empVo);
//         empFileService.insertEmpFile(retEmpVo);
//     }
//     return iRet;
		throw new Exception("개발중 코드");
		return null;
	}

	@BxmCategory(logicalName="FIXME-updateEmp", description="FIXME-updateEmp")
	public int updateEmp(EmpVo empVo) throws ElException, IOException
	{
//		TODO - 주석을 풀고 작성하세요.
//     int updRet = empDAO.updateEmp(empVo);
//     if (empVo.getInputFileData() != null && empVo.getInputFileData().getSize() > 0) {
//         EmpVo retEmpVo = (EmpVo) empVo.clone();
//         retEmpVo = getEmpVo(empVo);
//         empFileService.deleteEmpFile(retEmpVo);
//         empFileService.insertEmpFile(retEmpVo);
//     } else {
//         if (empVo.getFileName() == null || "".equals(empVo.getFileName())) {
//             // 첨부파일 삭제
//             empFileService.deleteEmpFile(empVo);
//         }
//     }
//     return updRet;
		throw new Exception("개발중 코드");
		return null;
	}

	@BxmCategory(logicalName="FIXME-deleteEmp", description="FIXME-deleteEmp")
	public int deleteEmp(EmpVo empVo) throws ElException
	{
//		TODO - 주석을 풀고 작성하세요.
//     int del = empDAO.deleteEmp(empVo);
//     empFileService.deleteEmpFile(empVo);
//     return del;
		throw new Exception("개발중 코드");
		return null;
	}

	@BxmCategory(logicalName="FIXME-selectListDept", description="FIXME-selectListDept")
	public ArrayList<DeptVo> selectListDept(HashMap searchKeyHm) throws ElException
	{
//		TODO - 주석을 풀고 작성하세요.
//     return empDAO.selectListDept(searchKeyHm);
		throw new Exception("개발중 코드");
		return null;
	}

	@BxmCategory(logicalName="FIXME-getEmpVo", description="FIXME-getEmpVo")
	private EmpVo getEmpVo(EmpVo empVo) throws ElException, IOException
	{
//		TODO - 주석을 풀고 작성하세요.
//     if (empVo.getInputFileData() == null) {
//         return null;
//     }
//     long iFileSize = empVo.getInputFileData().getSize();
//     if (iFileSize > 0) {
//         InputStream is = empVo.getInputFileData().getInputStream();
//         byte[] fileData = new byte[(int) iFileSize];
//         is.read(fileData);
//         is.close();
//         empVo.setFileName(empVo.getInputFileData().getOriginalFilename());
//         empVo.setFileData(fileData);
//     }
//     return empVo;
		throw new Exception("개발중 코드");
		return null;
	}

