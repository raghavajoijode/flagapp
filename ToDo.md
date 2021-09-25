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
			