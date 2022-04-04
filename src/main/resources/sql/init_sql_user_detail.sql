USE [test1]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[user_detail0](
	[id] [numeric](19, 0) NOT NULL,
	[create_time] [datetime] NULL,
	[phone] [varchar](16) NULL,
	[last_update_time] [datetime] NULL,
	[address] [varchar](64) NULL,
	[user_id] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


CREATE TABLE [dbo].[user_detail1](
	[id] [numeric](19, 0) NOT NULL,
	[create_time] [datetime] NULL,
	[phone] [varchar](16) NULL,
	[last_update_time] [datetime] NULL,
	[address] [varchar](64) NULL,
	[user_id] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO



USE [test2]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[user_detail0](
	[id] [numeric](19, 0) NOT NULL,
	[create_time] [datetime] NULL,
	[phone] [varchar](16) NULL,
	[last_update_time] [datetime] NULL,
	[address] [varchar](64) NULL,
	[user_id] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


CREATE TABLE [dbo].[user_detail1](
	[id] [numeric](19, 0) NOT NULL,
	[create_time] [datetime] NULL,
	[phone] [varchar](16) NULL,
	[last_update_time] [datetime] NULL,
	[address] [varchar](64) NULL,
	[user_id] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO