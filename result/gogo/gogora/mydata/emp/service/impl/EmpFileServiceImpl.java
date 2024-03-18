// FIXME - package 패키지 경로를 적어주세요 

// FIXME - import 정보를 적어주세요 


@Service
@BxmCategory(logicalName="EmpFileService", description="EmpFileService")
public class EmpFileService {

	@Autowired
	private EmpFileDAO empFileDAO;

	@BxmCategory(logicalName="FIXME-selectEmpFile", description="FIXME-selectEmpFile")
	public EmpVo selectEmpFile(EmpVo empVo) throws ElException
	{
//		TODO - 주석을 풀고 작성하세요.
//     EmpVo retVo = (EmpVo) empVo.clone();
//     retVo = empFileDAO.selectEmpFile(retVo);
//     return retVo;
		throw new Exception("개발중 코드");
		return null;
	}

	@BxmCategory(logicalName="FIXME-insertEmpFile", description="FIXME-insertEmpFile")
	public int insertEmpFile(EmpVo empVo) throws ElException
	{
//		TODO - 주석을 풀고 작성하세요.
//     return empFileDAO.insertEmpFile(empVo);
		throw new Exception("개발중 코드");
		return null;
	}

	@BxmCategory(logicalName="FIXME-updateEmpFile", description="FIXME-updateEmpFile")
	public int updateEmpFile(EmpVo empVo) throws ElException
	{
//		TODO - 주석을 풀고 작성하세요.
//     return empFileDAO.updateEmpFile(empVo);
		throw new Exception("개발중 코드");
		return null;
	}

	@BxmCategory(logicalName="FIXME-deleteEmpFile", description="FIXME-deleteEmpFile")
	public int deleteEmpFile(EmpVo empVo) throws ElException
	{
//		TODO - 주석을 풀고 작성하세요.
//     return empFileDAO.deleteEmpFile(empVo);
		throw new Exception("개발중 코드");
		return null;
	}

	@BxmCategory(logicalName="FIXME-uploadEmpFile", description="FIXME-uploadEmpFile")
	public void uploadEmpFile(EmpVo empVo) throws Exception
	{
//		TODO - 주석을 풀고 작성하세요.
//     if (empVo.getInputFileData() != null && empVo.getInputFileData().getSize() > 0) {
//         EmpVo retEmpVo = (EmpVo) empVo.clone();
//         retEmpVo = getEmpVo(empVo);
//         empFileDAO.deleteEmpFile(retEmpVo);
//         empFileDAO.insertEmpFile(retEmpVo);
//     }
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

