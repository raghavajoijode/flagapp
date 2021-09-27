Create Service

root-path: /etc/flag-app/flags

Create default project [From FlagAppService]() /etc/flag-app/flags/default [delete, publish, edit] [if default is edit/delete - create flag(say: createDefault:false) on root-path to not create by default]

FlagAppService -> project, flag, default value [Future scope -> create projects]
service -> flag, default value
config...

FlagAppService:
	-> activate	: If root-path has createDefault:true then create default-project
				: Create couple of test flags
				
	-> getFlag	:
		(project-name, flag-name, default-value)	:
		(project-name, flag-name, type:class)		:
	
	-> createFlag	:
		(project-name, flag-name, value)			:
		(project-name, flag-name, value, type:class)		:
		
	
project:
	-> name [node name - (dafault)]
	-> type [nt:unstructured]
	-> title [Project Title]
	
	:- flag1:
			-> value
			-> type [? future-scope]




________________________________________

Flag Base Path:
Template Page: 
1. Base Page 
   1. Contains List of Projects
   2. Create New Project Button
   3. Import Project [#future_scope]
   4. A project should have 
      1. open [view flags list]
      2. edit [title, other tags??]
      3. delete
      4. publish
      5. export [#future_scope]
2. Project Page
   1. Contains List of flags for the project
   2. A notification to show there are unpublished changes [#future_scope]
   3. Create New Flag Button
   4. Publish project 
   5. Export Project [#future_scope]
   6. Each flag has three options
      1. Edit
      2. Delete



On Activate
 -> Create flag root page - /content/flags (If not there)

-> Create 
			